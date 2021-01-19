package de.varoplugin.banapi;

import com.google.gson.annotations.SerializedName;

public class Account {

	@SerializedName("type")
	private int type;
	
	@SerializedName("id")
	private String id;

	public Account(AccountType type, String id) {
		super();
		this.type = type.getId();
		this.id = id;
	}
}
