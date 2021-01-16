package de.varoplugin.banapi.request;

import java.util.function.Consumer;

import de.varoplugin.banapi.VaroBanAPI;
import de.varoplugin.banapi.user.User;
import de.varoplugin.banapi.user.UsersDataWrapper;

public class ActiveBansRequest extends SupplierRequest<User[]> {
	
	ActiveBansRequest(VaroBanAPI api, String url) {
		super(api, url, User[].class);
	}
	
	public ActiveBansRequest(VaroBanAPI api) {
		this(api, "bans/active");
	}
	
	public UsersDataWrapper sendAndGetWrapper() throws RequestFailedException {
		return new UsersDataWrapper(send());
	}
	
	public void sendAsyncAndGetWrapper(Consumer<UsersDataWrapper> callback) {
		sendAsync((users) -> callback.accept(new UsersDataWrapper(users)));
	}
}
