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
	private final List<BanListener> listeners = new CopyOnWriteArrayList<>();
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

	public void schedule() {
		EXECUTOR.schedule(this::refreshData, this.refreshInterval, TimeUnit.SECONDS);
	}

	private void refreshData() {
		try {
			UsersDataWrapper users = null;
			if(this.timestamp != null)
				users = this.mode.getRequest(this.banAPI, this.timestamp).sendAndGetWrapper();
			
			if(this.currentData == null) {
				this.currentData = this.mode.getRequest(this.banAPI, null).sendAndGetWrapper();
				this.timestamp = new Timestamp(currentData.getRaw().getTimestamp());
			}
			
			if(users != null) {
				this.currentData.merge(users);
				this.timestamp = new Timestamp(users.getRaw().getTimestamp());
				
				for(BanListener listener : this.listeners)
					try {
						listener.onBanDataUpdated(users);
						
						for(User user : users.getRaw().getUsers()) {
							Ban ban;
							if((ban = user.getLatestMinecraftBan()) != null)
								listener.onBanUpdate(user, new UpdatedBan(user, ban, AccountType.MINECRAFT));
							if((ban = user.getLatestDiscordBan()) != null)
								listener.onBanUpdate(user, new UpdatedBan(user, ban, AccountType.DISCORD));
						}
							
					}catch(Throwable t) {
						if(this.exceptionHandler != null)
							exceptionHandler.accept(t);
					}
			}
		} catch (RequestFailedException e) {
			if (banAPI.getExceptionHandler() != null)
				banAPI.getExceptionHandler().accept(e);
		} finally {
			schedule();
		}
	}
	
	public void registerListener(BanListener listener) {
		this.listeners.add(listener);
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