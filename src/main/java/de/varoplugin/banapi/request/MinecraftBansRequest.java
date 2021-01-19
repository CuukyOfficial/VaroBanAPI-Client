package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;

public class MinecraftBansRequest extends BansRequest {
	
	public MinecraftBansRequest(VaroBanAPI api) {
		super(api, "mc");
	}
}
