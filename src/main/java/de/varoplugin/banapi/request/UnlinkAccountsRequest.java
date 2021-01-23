package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Account;
import de.varoplugin.banapi.BanApi;

public class UnlinkAccountsRequest extends CompleteRequest<Result> {

	public UnlinkAccountsRequest(BanApi api, Account link) {
		super(api, "unlink", api.getGson().toJson(link), Result.class);
	}
}
