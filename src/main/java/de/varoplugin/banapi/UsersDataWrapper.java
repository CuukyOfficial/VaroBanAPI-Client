package de.varoplugin.banapi;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UsersDataWrapper {

	private UserArray raw;
	private Map<UUID, BanUser> minecraftAccounts;
	private Map<Long, BanUser> discordAccounts;

	public UsersDataWrapper() {}

	public UsersDataWrapper(UserArray users) {
		this.raw = users;
		this.minecraftAccounts = new HashMap<>();
		this.discordAccounts = new HashMap<>();

		initData(users);
	}

	protected void initData(UserArray array) {
		for (BanUser user : array.getUsers()) {
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

	public BanUser getUser(AccountType type, String id) {
		switch (type) {
		case MINECRAFT:
			return this.getUser(UUID.fromString(id));
		case DISCORD:
			return this.getUser(Long.parseLong(id));
		default:
			throw new Error();
		}
	}

	public BanUser getUser(UUID uuid) {
		return this.minecraftAccounts.get(uuid);
	}

	public BanUser getUser(Long id) {
		return this.discordAccounts.get(id);
	}
}
