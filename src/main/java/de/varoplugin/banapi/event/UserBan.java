package de.varoplugin.banapi.event;

import de.varoplugin.banapi.Ban;
import de.varoplugin.banapi.User;

public class UserBan {

	private final User user;
	private final Ban ban;

	public UserBan(User user, Ban ban) {
		this.user = user;
		this.ban = ban;
	}

	public User getUser() {
		return user;
	}

	public Ban getBan() {
		return ban;
	}
}