package de.varoplugin.banapi;

import com.google.gson.annotations.SerializedName;

public class AccountLink {

	@SerializedName("type")
	private int oldType;

	@SerializedName("id")
	private String oldId;

	@SerializedName("name")
	private String name;

	@SerializedName("from")
	private Account[] newAccounts;

	@Deprecated
	public AccountLink(String name, AccountType oldType, AccountType newType, String oldId, String newId) {
		this.oldId = oldId;
		this.oldType = oldType.getId();
		this.name = name;

		this.newAccounts = new Account[] {new Account(newType, newId)};
	}

	public AccountLink(Account oldAccount, String name, Account... newAccounts) {
		this.oldId = oldAccount.getId();
		this.oldType = oldAccount.getType();
		this.name = name;	
		this.newAccounts = newAccounts;	
	}
}
