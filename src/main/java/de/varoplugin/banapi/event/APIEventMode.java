package de.varoplugin.banapi.event;

import de.varoplugin.banapi.BanAPI;
import de.varoplugin.banapi.request.ActiveBansRequest;
import de.varoplugin.banapi.request.ActiveDiscordBansRequest;
import de.varoplugin.banapi.request.ActiveMinecraftBansRequest;
import de.varoplugin.banapi.request.BansRequest;

public enum APIEventMode {

	ALL,
	DISCORD_ONLY,
	MINECRAFT_ONLY;

	public BansRequest getRequest(BanAPI api) {
		switch (this) {
		case MINECRAFT_ONLY:
			return new ActiveMinecraftBansRequest(api);
		case DISCORD_ONLY:
			return new ActiveDiscordBansRequest(api);
		default:
			return new ActiveBansRequest(api);
		}
	}
}