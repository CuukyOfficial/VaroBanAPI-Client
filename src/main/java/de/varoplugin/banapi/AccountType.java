package de.varoplugin.banapi;

public enum AccountType {

	MINERAFT(0), DISCORD(1);
	
	private int id;
	
	private AccountType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
