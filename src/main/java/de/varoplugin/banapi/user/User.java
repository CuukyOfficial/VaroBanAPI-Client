package de.varoplugin.banapi.user;

import com.google.gson.annotations.SerializedName;

public class User {
	
	@SerializedName("userID")
	private long userid;

	@SerializedName("timestamp")
	private long timestamp;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("minecraftBans")
	private Ban[] minecraftBans;
	
	@SerializedName("discordBans")
	private Ban[] discordBans;
	
	@SerializedName("minecraftAccounts")
	private String[] minecraftUuids;
	
	@SerializedName("discordAccounts")
	private long[] discordIds;
	
	public User() {}

	public long getUserid() {
		return userid;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getName() {
		return name;
	}

	public Ban[] getMinecraftBans() {
		return minecraftBans;
	}

	public Ban[] getDiscordBans() {
		return discordBans;
	}

	public String[] getMinecraftUuids() {
		return minecraftUuids;
	}

	public long[] getDiscordIds() {
		return discordIds;
	}
}