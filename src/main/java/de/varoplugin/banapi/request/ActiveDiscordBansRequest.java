package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanAPI;

public class ActiveDiscordBansRequest extends BansRequest {
	
	public ActiveDiscordBansRequest(BanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveDiscordBansRequest(BanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveDiscordBansRequest(BanAPI api) {
		super(api, "dc/active");
	}
}
