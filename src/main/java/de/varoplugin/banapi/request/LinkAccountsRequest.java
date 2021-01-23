package de.varoplugin.banapi.request;

import de.varoplugin.banapi.AccountLink;
import de.varoplugin.banapi.BanAPI;

public class LinkAccountsRequest extends CompleteRequest<Result> {

	public LinkAccountsRequest(BanAPI api, AccountLink link) {
		super(api, "link", api.getGson().toJson(link), Result.class);
	}
}
