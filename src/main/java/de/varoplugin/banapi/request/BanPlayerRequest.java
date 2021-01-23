package de.varoplugin.banapi.request;

import de.varoplugin.banapi.PlayerBan;
import de.varoplugin.banapi.BanApi;

public class BanPlayerRequest extends SupplierRequest {

	public BanPlayerRequest(BanApi api, PlayerBan ban) {
		super(api, "ban", api.getGson().toJson(ban));
	}
}
