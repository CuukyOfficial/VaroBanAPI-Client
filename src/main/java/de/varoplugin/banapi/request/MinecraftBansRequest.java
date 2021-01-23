package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanAPI;

public class MinecraftBansRequest extends BansRequest {
	
	public MinecraftBansRequest(BanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public MinecraftBansRequest(BanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public MinecraftBansRequest(BanAPI api) {
		super(api, "mc");
	}
}
