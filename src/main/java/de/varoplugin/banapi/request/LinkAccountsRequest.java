package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;
import de.varoplugin.banapi.user.AccountLink;

public class LinkAccountsRequest extends CompleteRequest<Result> {

	public LinkAccountsRequest(VaroBanAPI api, AccountLink link) {
		super(api, "link", api.getGson().toJson(link), Result.class);
	}
}
