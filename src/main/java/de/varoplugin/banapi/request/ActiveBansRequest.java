package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanAPI;

public class ActiveBansRequest extends BansRequest {
	
	public ActiveBansRequest(BanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveBansRequest(BanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveBansRequest(BanAPI api) {
		super(api, "bans/active");
	}
}
