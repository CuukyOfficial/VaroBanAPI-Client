package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;

public class ActiveDiscordBansRequest extends ActiveBansRequest {
	
	public ActiveDiscordBansRequest(VaroBanAPI api) {
		super(api, "dc/active");
	}
}
