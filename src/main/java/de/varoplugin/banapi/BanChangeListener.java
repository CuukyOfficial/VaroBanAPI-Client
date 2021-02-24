package de.varoplugin.banapi;

public interface BanChangeListener extends BanListener {

	public void onBanUpdate(BanUser user, Ban ban, AccountType type);
}