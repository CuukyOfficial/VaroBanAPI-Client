package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanApi;

public class DiscordBansRequest extends BansRequest {
	
	public DiscordBansRequest(BanApi api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public DiscordBansRequest(BanApi api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public DiscordBansRequest(BanApi api) {
		super(api, "dc");
	}
}
