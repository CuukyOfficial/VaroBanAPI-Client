package de.varoplugin.banapi;

import com.google.gson.annotations.SerializedName;

public class UserArray {

	@SerializedName("users")
	private User[] users;
	
	@SerializedName("timestamp")
	private long timestamp;
	
	public UserArray() {}
	
	public User[] getUsers() {
		return users;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
}
