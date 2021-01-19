package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;

public class DiscordBansRequest extends BansRequest {
	
	public DiscordBansRequest(VaroBanAPI api) {
		super(api, "dc");
	}
}
