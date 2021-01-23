package de.varoplugin.banapi;

public interface BanListener {

	public void onBanUpdate(User user, UpdatedBan ban);
	public void onBanDataUpdated(UsersDataWrapper data);
}