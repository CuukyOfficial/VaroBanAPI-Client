package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;
import de.varoplugin.banapi.user.PlayerBan;

public class BanPlayerRequest extends SupplierRequest {

	public BanPlayerRequest(VaroBanAPI api, PlayerBan ban) {
		super(api, "ban", api.getGson().toJson(ban));
	}
}
