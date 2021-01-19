package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.VaroBanAPI;

public class MinecraftBansRequest extends BansRequest {
	
	public MinecraftBansRequest(VaroBanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public MinecraftBansRequest(VaroBanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public MinecraftBansRequest(VaroBanAPI api) {
		super(api, "mc");
	}
}
