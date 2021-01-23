package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanAPI;

public class ActiveMinecraftBansRequest extends BansRequest {
	
	public ActiveMinecraftBansRequest(BanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveMinecraftBansRequest(BanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveMinecraftBansRequest(BanAPI api) {
		super(api, "mc/active");
	}
}
