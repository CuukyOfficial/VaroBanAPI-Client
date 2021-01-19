package de.varoplugin.banapi.request;

import java.util.function.Consumer;

import de.varoplugin.banapi.VaroBanAPI;
import de.varoplugin.banapi.user.UserArray;
import de.varoplugin.banapi.user.UsersDataWrapper;

public class BansRequest extends ConsumerRequest<UserArray> {

	BansRequest(VaroBanAPI api, String url) {
		super(api, url, UserArray.class);
	}
	
	public BansRequest(VaroBanAPI api) {
		this(api, "bans");
	}
	
	public UsersDataWrapper sendAndGetWrapper() throws RequestFailedException {
		return new UsersDataWrapper(send());
	}
	
	public void sendAsyncAndGetWrapper(Consumer<UsersDataWrapper> callback) {
		sendAsync((users) -> callback.accept(new UsersDataWrapper(users)));
	}
}
