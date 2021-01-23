package de.varoplugin.banapi.request;

import java.util.function.Consumer;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.UserArray;
import de.varoplugin.banapi.UsersDataWrapper;
import de.varoplugin.banapi.BanAPI;

public class BansRequest extends CompleteRequest<UserArray> {
	
	BansRequest(BanAPI api, String url, Timestamp timestamp) {
		super(api, url, api.getGson().toJson(timestamp), UserArray.class);
	}
	
	BansRequest(BanAPI api, String url, long timestamp) {
		super(api, url, api.getGson().toJson(new Timestamp(timestamp)), UserArray.class);
	}

	BansRequest(BanAPI api, String url) {
		super(api, url, null, UserArray.class);
	}
	
	public BansRequest(BanAPI api, Timestamp timestamp) {
		this(api, "bans", timestamp);
	}
	
	public BansRequest(BanAPI api, long timestamp) {
		this(api, "bans", timestamp);
	}
	
	public BansRequest(BanAPI api) {
		this(api, "bans");
	}
	
	public UsersDataWrapper sendAndGetWrapper() throws RequestFailedException {
		return new UsersDataWrapper(send());
	}
	
	public void sendAsyncAndGetWrapper(Consumer<UsersDataWrapper> callback) {
		sendAsync((users) -> callback.accept(new UsersDataWrapper(users)));
	}
}
