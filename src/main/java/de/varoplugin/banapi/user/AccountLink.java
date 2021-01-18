package de.varoplugin.banapi.user;

import com.google.gson.annotations.SerializedName;

public class AccountLink {

	@SerializedName("oldType")
	private int oldType;
	
	@SerializedName("newType")
	private int newType;
	
	@SerializedName("oldId")
	private String oldId;
	
	@SerializedName("newId")
	private String newId;

	public AccountLink(AccountType oldType, AccountType newType, String oldId, String newId) {
		super();
		this.oldType = oldType.getId();
		this.newType = newType.getId();
		this.oldId = oldId;
		this.newId = newId;
	}
}
