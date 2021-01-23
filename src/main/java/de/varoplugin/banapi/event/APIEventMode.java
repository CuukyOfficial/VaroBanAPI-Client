package de.varoplugin.banapi.event;

import de.varoplugin.banapi.BanAPI;
import de.varoplugin.banapi.request.ActiveBansRequest;
import de.varoplugin.banapi.request.BansRequest;
import de.varoplugin.banapi.request.DiscordBansRequest;
import de.varoplugin.banapi.request.MinecraftBansRequest;

public enum APIEventMode {

	ALL,
	DISCORD_ONLY,
	MINECRAFT_ONLY;

	public BansRequest getRequest(BanAPI api) {
		switch (this) {
		case MINECRAFT_ONLY:
			return new MinecraftBansRequest(api);
		case DISCORD_ONLY:
			return new DiscordBansRequest(api);
		default:
			return new ActiveBansRequest(api);
		}
	}
}