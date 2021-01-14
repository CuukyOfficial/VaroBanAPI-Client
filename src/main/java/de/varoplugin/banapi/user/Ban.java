package de.varoplugin.banapi.user;

import com.google.gson.annotations.SerializedName;

public class Ban {

	public static final short TYPE_MINECRAFT = 0;
	public static final short TYPE_DISCORD = 1;
	
	@SerializedName("userid")
	private long userid;
	
	@SerializedName("id")
	private long id;
	
	@SerializedName("type")
	private short type;
	
	@SerializedName("timestamp")
	private long timestamp;
	
	@SerializedName("duration")
	private long duration;
	
	@SerializedName("reason")
	private String reason;
	
	@SerializedName("proofs")
	private String[] proofs;
	
	@SerializedName("notes")
	private String notes;
	
	@SerializedName("bannedby")
	private String operator;
	
}
