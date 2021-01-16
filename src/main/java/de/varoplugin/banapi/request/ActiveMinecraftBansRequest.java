package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;

public class ActiveMinecraftBansRequest extends ActiveBansRequest {
	
	public ActiveMinecraftBansRequest(VaroBanAPI api) {
		super(api, "mc/active");
	}
}
