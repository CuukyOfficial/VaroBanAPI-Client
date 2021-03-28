package de.varoplugin.banapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public enum AccountType {

	@Expose()
	@SerializedName("mc")
	MINECRAFT(0),
	@Expose()
	@SerializedName("dc")
	DISCORD(1);
	
	private int id;
	
	private AccountType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
