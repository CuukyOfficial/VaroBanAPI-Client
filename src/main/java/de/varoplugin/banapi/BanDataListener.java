package de.varoplugin.banapi;

public interface BanDataListener extends BanListener {

	public void onBanDataUpdated(UsersDataWrapper data);
}