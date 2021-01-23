package de.varoplugin.banapi;

public interface BanListener {

	public void onBanUpdate(User user, Ban ban, AccountType type);
	public void onBanDataUpdated(UsersDataWrapper data);
}