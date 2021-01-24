package de.varoplugin.banapi;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import de.varoplugin.banapi.request.ActiveBansRequest;
import de.varoplugin.banapi.request.ActiveDiscordBansRequest;
import de.varoplugin.banapi.request.ActiveMinecraftBansRequest;
import de.varoplugin.banapi.request.BansRequest;
import de.varoplugin.banapi.request.RequestFailedException;

public class ActiveBansHandler {

	private static final ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor();

	private final BanApi banAPI;
	private final Mode mode;
	private final Consumer<Throwable> exceptionHandler;
	private final List<BanChangeListener> changeListeners = new CopyOnWriteArrayList<>();
	private final List<BanDataListener> dataListeners = new CopyOnWriteArrayList<>();
	private final int refreshInterval;
	private Timestamp timestamp;
	private UsersDataWrapper currentData;

	public ActiveBansHandler(BanApi banAPI, Mode mode, Consumer<Throwable> exceptionHandler, int refreshInterval, Timestamp timestamp) {
		this.banAPI = banAPI;
		this.mode = mode;
		this.exceptionHandler = exceptionHandler;
		this.refreshInterval = refreshInterval;
		this.timestamp = timestamp;
	}

	public ActiveBansHandler(BanApi banAPI, Mode mode, Consumer<Throwable> exceptionHandler) {
		this(banAPI, mode, exceptionHandler, 5 * 60, null);
	}

	public void start() {
		EXECUTOR.execute(this::refreshData);
	}

	private void schedule() {
		EXECUTOR.schedule(this::refreshData, this.refreshInterval, TimeUnit.SECONDS);
	}

	private void refreshData() {
		try {
			UsersDataWrapper data = this.currentData = this.mode.getRequest(this.banAPI, this.timestamp).sendAndGetWrapper();
			this.timestamp = new Timestamp(data.getRaw().getTimestamp());

			for(BanDataListener listener : this.dataListeners)
				try {
					listener.onBanDataUpdated(data);
				}catch(Throwable t) {
					if(this.exceptionHandler != null)
						exceptionHandler.accept(t);
				}

			for(User user : data.getRaw().getUsers()) {
				Ban ban;
				if(user.isMinecraftBansChanged())
					if((ban = user.getLatestMinecraftBan()) != null)
						runChangeListeners(user, ban, AccountType.MINECRAFT);
				if(user.isDiscordBansChanged())
					if((ban = user.getLatestDiscordBan()) != null)
						runChangeListeners(user, ban, AccountType.DISCORD);
			}
		} catch (RequestFailedException e) {
			if (banAPI.getExceptionHandler() != null)
				banAPI.getExceptionHandler().accept(e);
		} finally {
			schedule();
		}
	}

	private void runChangeListeners(User user, Ban ban, AccountType type) {
		for(BanChangeListener listener : this.changeListeners)
			try {
				listener.onBanUpdate(user, ban, type);
			}catch(Throwable t) {
				if(this.exceptionHandler != null)
					exceptionHandler.accept(t);
			}
	}

	public void registerListener(BanListener listener) {
		if(listener instanceof BanChangeListener)
			this.changeListeners.add((BanChangeListener) listener);
		if(listener instanceof BanDataListener)
			this.dataListeners.add((BanDataListener) listener);
	}

	public UsersDataWrapper getCurrentData() {
		return currentData;
	}

	public static enum Mode {

		ALL(ActiveBansRequest::new),
		DISCORD_ONLY(ActiveDiscordBansRequest::new),
		MINECRAFT_ONLY(ActiveMinecraftBansRequest::new);

		private BiFunction<BanApi, Timestamp, BansRequest> request;

		private Mode(BiFunction<BanApi, Timestamp, BansRequest> request) {
			this.request = request;
		}

		public BansRequest getRequest(BanApi api, Timestamp timestamp) {
			return this.request.apply(api, timestamp);
		}
	}
}