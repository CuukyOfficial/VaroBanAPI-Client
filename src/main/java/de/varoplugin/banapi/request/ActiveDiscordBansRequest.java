package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.VaroBanAPI;

public class ActiveDiscordBansRequest extends BansRequest {
	
	public ActiveDiscordBansRequest(VaroBanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveDiscordBansRequest(VaroBanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveDiscordBansRequest(VaroBanAPI api) {
		super(api, "dc/active");
	}
}
