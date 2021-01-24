package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanApi;

public class LatestMinecraftBansRequest extends BansRequest {
	
	public LatestMinecraftBansRequest(BanApi api, Timestamp timestamp) {
		super(api, "mc/latest", timestamp);
	}
	
	public LatestMinecraftBansRequest(BanApi api, long timestamp) {
		super(api, "mc/latest", timestamp);
	}
	
	public LatestMinecraftBansRequest(BanApi api) {
		super(api, "mc/latest");
	}
}
