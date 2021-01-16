package de.varoplugin.banapi.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UsersDataWrapper {

	private final User[] users;
	private final Map<UUID, Ban> minecraftBans;
	private final Map<Long, Ban> discordBans;
	
	public UsersDataWrapper(User... users) {
		this.users = users;
		this.minecraftBans = new HashMap<>();
		this.discordBans = new HashMap<>();
		
		initData();
	}
	
	private void initData() {
		for(User user : this.users) {
			if(user.getMinecraftUuids() != null && user.getMinecraftBans() != null && user.getMinecraftBans().length != 0)
				for(String uuid : user.getMinecraftUuids())
					this.minecraftBans.put(UUID.fromString(uuid), user.getMinecraftBans()[0]);
			if(user.getDiscordIds() != null && user.getDiscordBans() != null && user.getDiscordBans().length != 0)
				for(Long id : user.getDiscordIds())
					this.discordBans.put(id, user.getDiscordBans()[0]);
		}
	}
	
	public Ban getCurrentMinecraftBan(UUID uuid) {
		return this.minecraftBans.get(uuid);
	}
	
	public boolean isMinecraftBanned(UUID uuid) {
		return this.minecraftBans.containsKey(uuid);
	}
	
	public Ban getCurrentDiscordBan(Long id) {
		return this.discordBans.get(id);
	}
	
	public boolean isDiscordBanned(Long id) {
		return this.discordBans.containsKey(id);
	}
}
