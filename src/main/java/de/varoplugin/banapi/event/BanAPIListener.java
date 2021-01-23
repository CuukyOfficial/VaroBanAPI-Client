package de.varoplugin.banapi.event;

import de.varoplugin.banapi.AccountType;
import de.varoplugin.banapi.UsersDataWrapper;

public interface BanAPIListener {

	public default void onAccountBan(AccountType type, String id) {}

	public default void onAccountUnban(AccountType type, String id) {}

	public default void onDataReceive(UsersDataWrapper data) {}

}