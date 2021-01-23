package de.varoplugin.banapi.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.varoplugin.banapi.AccountType;
import de.varoplugin.banapi.BanAPI;
import de.varoplugin.banapi.UsersDataWrapper;
import de.varoplugin.banapi.request.ActiveBansRequest;
import de.varoplugin.banapi.request.RequestFailedException;

public class BanEventManager {

	private final BanAPI banAPI;
	private final List<BanAPIListener> listener = new ArrayList<>();
	private UsersDataWrapper compare;
	private int fetchInterval = 60;

	public BanEventManager(BanAPI banAPI) {
		this.banAPI = banAPI;
	}

	private void startFetching() {
		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(this.fetchInterval * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				this.executeComparison(this.fetchNewData());
			}
		}).start();
	}

	private UsersDataWrapper fetchNewData() {
		try {
			UsersDataWrapper result = new ActiveBansRequest(this.banAPI).sendAndGetWrapper();
			this.listener.forEach(listener -> listener.onDataReceive(result));
			return result;
		} catch (RequestFailedException e) {
			if (banAPI.getExceptionHandler() != null)
				banAPI.getExceptionHandler().accept(e);
		}

		return null;
	}

	private <T> void executeMap(Map<T, CompareResult> map, AccountType type) {
		for (T id : map.keySet()) {
			CompareResult compare = map.get(id);
			if (compare == CompareResult.ADDED)
				this.listener.forEach(listener -> listener.onAccountBan(type, String.valueOf(id)));
			else if (compare == CompareResult.REMOVED)
				this.listener.forEach(listener -> listener.onAccountUnban(type, String.valueOf(id)));
		}
	}

	public void initialize() {
		this.initialize(null);
	}

	public void initialize(UsersDataWrapper data) {
		this.startFetching();
		this.compare = data == null ? this.fetchNewData() : data;

		if (data != null)
			this.executeComparison(this.fetchNewData());
	}

	public void executeComparison(UsersDataWrapper data) {
		ComparisonWrapper result = new ComparisonWrapper(this.compare, data);
		this.executeMap(result.getDiscordResult(), AccountType.DISCORD);
		this.executeMap(result.getMinecraftResult(), AccountType.MINERAFT);

		this.compare = data;
	}

	public void registerListener(BanAPIListener listener) {
		this.listener.add(listener);
	}

	public void setFetchInterval(int fetchInterval) {
		this.fetchInterval = fetchInterval;
	}
}