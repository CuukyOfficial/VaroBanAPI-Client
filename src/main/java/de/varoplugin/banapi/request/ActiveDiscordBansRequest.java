package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanApi;

public class ActiveDiscordBansRequest extends BansRequest {
	
	public ActiveDiscordBansRequest(BanApi api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveDiscordBansRequest(BanApi api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveDiscordBansRequest(BanApi api) {
		super(api, "dc/active");
	}
}
