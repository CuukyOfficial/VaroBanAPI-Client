package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanApi;

public class ActiveMinecraftBansRequest extends BansRequest {
	
	public ActiveMinecraftBansRequest(BanApi api, Timestamp timestamp) {
		super(api, "mc/latest", timestamp);
	}
	
	public ActiveMinecraftBansRequest(BanApi api, long timestamp) {
		super(api, "mc/latest", timestamp);
	}
	
	public ActiveMinecraftBansRequest(BanApi api) {
		super(api, "mc/latest");
	}
}
