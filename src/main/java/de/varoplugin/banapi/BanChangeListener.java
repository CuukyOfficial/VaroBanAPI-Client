package de.varoplugin.banapi;

public interface BanChangeListener extends BanListener {

	public void onBanUpdate(User user, Ban ban, AccountType type);
}