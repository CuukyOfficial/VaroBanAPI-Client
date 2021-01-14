package de.varoplugin.banapi.user;

import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("timestamp")
	private long timestamp;
	
	@SerializedName("userid")
	private long userid;
	
	@SerializedName("minecraftUuids")
	private String[] minecraftUuids;
	
	@SerializedName("discordIds")
	private long[] discordIds;
	
}