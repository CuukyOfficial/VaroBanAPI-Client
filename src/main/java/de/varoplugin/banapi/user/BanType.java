package de.varoplugin.banapi.user;

public enum BanType {

	MINERAFT(0), DISCORD(1);
	
	private int id;
	
	private BanType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
