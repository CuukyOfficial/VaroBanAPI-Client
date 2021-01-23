package de.varoplugin.banapi;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UsersDataWrapper {

	private UserArray raw;
	private Map<UUID, User> minecraftAccounts;
	private Map<Long, User> discordAccounts;

	public UsersDataWrapper() {}

	public UsersDataWrapper(UserArray users) {
		this.raw = users;
		this.minecraftAccounts = new HashMap<>();
		this.discordAccounts = new HashMap<>();

		initData(users);
	}

	protected void initData(UserArray array) {
		for (User user : array.getUsers()) {
			if (user.getMinecraftUuids() != null)
				for (String uuidString : user.getMinecraftUuids()) {
					UUID uuid = UUID.fromString(uuidString);
					this.minecraftAccounts.put(uuid, user);
				}

			if (user.getDiscordIds() != null)
				for (long id : user.getDiscordIds()) {
					this.discordAccounts.put(id, user);
				}
		}
	}

	public UserArray getRaw() {
		return raw;
	}

	public User getUser(UUID uuid) {
		return this.minecraftAccounts.get(uuid);
	}

	public User getUser(Long id) {
		return this.discordAccounts.get(id);
	}
}
