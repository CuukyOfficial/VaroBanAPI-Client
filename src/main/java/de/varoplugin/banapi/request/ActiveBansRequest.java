package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.VaroBanAPI;

public class ActiveBansRequest extends BansRequest {
	
	public ActiveBansRequest(VaroBanAPI api, Timestamp timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveBansRequest(VaroBanAPI api, long timestamp) {
		super(api, "bans/active", timestamp);
	}
	
	public ActiveBansRequest(VaroBanAPI api) {
		super(api, "bans/active");
	}
}
