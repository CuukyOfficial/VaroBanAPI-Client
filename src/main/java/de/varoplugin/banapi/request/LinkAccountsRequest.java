package de.varoplugin.banapi.request;

import de.varoplugin.banapi.AccountLink;
import de.varoplugin.banapi.BanApi;

public class LinkAccountsRequest extends CompleteRequest<Result> {

	public LinkAccountsRequest(BanApi api, AccountLink link) {
		super(api, "link", api.getGson().toJson(link), Result.class);
	}
}
