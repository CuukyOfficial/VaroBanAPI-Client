package de.varoplugin.banapi.event;

import de.varoplugin.banapi.Ban;

public class UserBanPair<T> {

	private final T userID;
	private final Ban ban;

	public UserBanPair(T userID, Ban ban) {
		this.userID = userID;
		this.ban = ban;
	}

	public T getUserID() {
		return userID;
	}

	public Ban getBan() {
		return ban;
	}
}