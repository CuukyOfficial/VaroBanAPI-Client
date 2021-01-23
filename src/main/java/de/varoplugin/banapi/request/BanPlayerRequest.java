package de.varoplugin.banapi.request;

import de.varoplugin.banapi.PlayerBan;
import de.varoplugin.banapi.BanAPI;

public class BanPlayerRequest extends SupplierRequest {

	public BanPlayerRequest(BanAPI api, PlayerBan ban) {
		super(api, "ban", api.getGson().toJson(ban));
	}
}
