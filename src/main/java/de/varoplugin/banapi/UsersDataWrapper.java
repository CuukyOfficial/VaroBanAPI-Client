package de.varoplugin.banapi;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UsersDataWrapper {

	private final Map<UUID, User> minecraftAccounts;
	private final Map<Long, User> discordAccounts;
	private final Map<UUID, Ban> minecraftBans;
	private final Map<Long, Ban> discordBans;

	public UsersDataWrapper(UserArray users) {
		this.minecraftAccounts = new HashMap<>();
		this.discordAccounts = new HashMap<>();
		this.minecraftBans = new HashMap<>();
		this.discordBans = new HashMap<>();

		initData(users);
	}

	protected void initData(UserArray array) {
		for(User user : array.getUsers()) {
			Ban ban;
			if(user.getMinecraftUuids() != null) {
				ban = user.getActiveMinecraftBan();
				for(String uuidString : user.getMinecraftUuids()) {
					UUID uuid = UUID.fromString(uuidString);
					this.minecraftAccounts.put(uuid, user);
					
					if(ban != null)
						this.minecraftBans.put(uuid, ban);
				}
			}
			
			if(user.getDiscordIds() != null) {
				ban = user.getActiveDiscordBan();
				for(long id : user.getDiscordIds()) {
					this.discordAccounts.put(id, user);
					
					if(ban != null)
						this.discordBans.put(id, ban);
				}
			}
		}
	}
	
	public User getUser(UUID uuid) {
		return this.minecraftAccounts.get(uuid);
	}
	
	public User getUser(Long id) {
		return this.discordAccounts.get(id);
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
