package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanApi;

public class ActiveBansRequest extends BansRequest {
	
	public ActiveBansRequest(BanApi api, Timestamp timestamp) {
		super(api, "bans/latest", timestamp);
	}
	
	public ActiveBansRequest(BanApi api, long timestamp) {
		super(api, "bans/latest", timestamp);
	}
	
	public ActiveBansRequest(BanApi api) {
		super(api, "bans/latest");
	}
}
