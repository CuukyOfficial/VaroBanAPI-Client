package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.VaroBanAPI;

public class ActiveMinecraftBansRequest extends BansRequest {
	
	public ActiveMinecraftBansRequest(VaroBanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveMinecraftBansRequest(VaroBanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveMinecraftBansRequest(VaroBanAPI api) {
		super(api, "mc/active");
	}
}
