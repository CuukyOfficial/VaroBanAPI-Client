package de.varoplugin.banapi.request;

import de.varoplugin.banapi.AccountLink;
import de.varoplugin.banapi.BanApi;

public class MergeAccountsRequest extends CompleteRequest<Result> {

	public MergeAccountsRequest(BanApi api, AccountLink link) {
		super(api, "merge", api.getGson().toJson(link), Result.class);
	}
}
