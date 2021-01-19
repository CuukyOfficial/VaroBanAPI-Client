package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;
import de.varoplugin.banapi.user.Account;

public class UnlinkAccountsRequest extends CompleteRequest<Result> {

	public UnlinkAccountsRequest(VaroBanAPI api, Account link) {
		super(api, "unlink", api.getGson().toJson(link), Result.class);
	}
}
