package de.varoplugin.banapi;

public class UpdatedBan {
	
	private User user;
	private Ban ban;
	private AccountType type;

	UpdatedBan(User user, Ban ban, AccountType type) {
		this.user = user;
		this.ban = ban;
		this.type = type;
	}
	
	public User getUser() {
		return user;
	}
	
	public Ban getBan() {
		return ban;
	}
	
	public AccountType getType() {
		return type;
	}
}
