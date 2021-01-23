package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanApi;

public class MinecraftBansRequest extends BansRequest {
	
	public MinecraftBansRequest(BanApi api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public MinecraftBansRequest(BanApi api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public MinecraftBansRequest(BanApi api) {
		super(api, "mc");
	}
}
