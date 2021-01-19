package de.varoplugin.banapi;

import com.google.gson.annotations.SerializedName;

public class Timestamp {

	@SerializedName("timestamp")
	private long timestamp;
	
	public Timestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
}
