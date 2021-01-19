package de.varoplugin.banapi.request;

import de.varoplugin.banapi.PlayerBan;
import de.varoplugin.banapi.VaroBanAPI;

public class BanPlayerRequest extends SupplierRequest {

	public BanPlayerRequest(VaroBanAPI api, PlayerBan ban) {
		super(api, "ban", api.getGson().toJson(ban));
	}
}
