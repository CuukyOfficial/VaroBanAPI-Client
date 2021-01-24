package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanApi;

public class LatestBansRequest extends BansRequest {
	
	public LatestBansRequest(BanApi api, Timestamp timestamp) {
		super(api, "bans/latest", timestamp);
	}
	
	public LatestBansRequest(BanApi api, long timestamp) {
		super(api, "bans/latest", timestamp);
	}
	
	public LatestBansRequest(BanApi api) {
		super(api, "bans/latest");
	}
}
