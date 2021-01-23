package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanAPI;

public class DiscordBansRequest extends BansRequest {
	
	public DiscordBansRequest(BanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public DiscordBansRequest(BanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public DiscordBansRequest(BanAPI api) {
		super(api, "dc");
	}
}
