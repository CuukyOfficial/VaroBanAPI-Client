package de.varoplugin.banapi;

import com.google.gson.annotations.SerializedName;

public class PlayerBan {
	
	@SerializedName("type")
	private int type;

	@SerializedName("id")
	private String id;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("ban")
	private Ban ban;
	
	public PlayerBan(AccountType type, String id, String name, Ban ban) {
		this.type = type.getId();
		this.id = id;
		this.name = name;
		this.ban = ban;
	}
}
