package de.varoplugin.banapi;

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
	
	public boolean hasActiveMinecraftBan() {
		return this.minecraftBans != null && this.minecraftBans.length != 0 && this.minecraftBans[0].isActive();
	}
	
	public Ban getLatestMinecraftBan() {
		return hasActiveMinecraftBan() ? this.minecraftBans[0] : null;
	}
	
	public Ban[] getDiscordBans() {
		return discordBans;
	}
	
	public boolean hasActiveDiscordBan() {
		return this.discordBans != null && this.discordBans.length != 0 && this.discordBans[0].isActive();
	}
	
	public Ban getLatestDiscordBan() {
		return hasActiveDiscordBan() ? this.discordBans[0] : null;
	}

	public String[] getMinecraftUuids() {
		return minecraftUuids;
	}

	public long[] getDiscordIds() {
		return discordIds;
	}
}