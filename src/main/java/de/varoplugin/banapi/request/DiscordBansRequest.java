package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.VaroBanAPI;

public class DiscordBansRequest extends BansRequest {
	
	public DiscordBansRequest(VaroBanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public DiscordBansRequest(VaroBanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public DiscordBansRequest(VaroBanAPI api) {
		super(api, "dc");
	}
}
