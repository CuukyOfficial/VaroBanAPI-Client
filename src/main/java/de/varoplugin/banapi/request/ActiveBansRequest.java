package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;

public class ActiveBansRequest extends BansRequest {
	
	public ActiveBansRequest(VaroBanAPI api) {
		super(api, "bans/active");
	}
}
