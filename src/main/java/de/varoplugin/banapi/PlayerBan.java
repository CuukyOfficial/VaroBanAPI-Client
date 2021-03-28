package de.varoplugin.banapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerBan {

	@Expose
	@SerializedName("type")
	private int type;

	@Expose
	@SerializedName("id")
	private String id;

	@Expose
	@SerializedName("name")
	private String name;

	@Expose
	@SerializedName("ban")
	private Ban ban;

	public PlayerBan(AccountType type, String id, String name, Ban ban) {
		this.type = type.getId();
		this.id = id;
		this.name = name;
		this.ban = ban;
	}

	public int getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Ban getBan() {
		return ban;
	}
}
