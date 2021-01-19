package de.varoplugin.banapi.request;

import de.varoplugin.banapi.AccountLink;
import de.varoplugin.banapi.VaroBanAPI;

public class LinkAccountsRequest extends CompleteRequest<Result> {

	public LinkAccountsRequest(VaroBanAPI api, AccountLink link) {
		super(api, "link", api.getGson().toJson(link), Result.class);
	}
}
