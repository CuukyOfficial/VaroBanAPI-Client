package de.varoplugin.banapi.event;

import de.varoplugin.banapi.AccountType;
import de.varoplugin.banapi.Ban;
import de.varoplugin.banapi.UsersDataWrapper;

public interface BanAPIListener {

	public default void onAccountBan(String id, Ban ban, AccountType type) {}

	public default void onAccountUnban(String id, Ban ban, AccountType type) {}

	public default void onDataReceive(UsersDataWrapper data) {}

}