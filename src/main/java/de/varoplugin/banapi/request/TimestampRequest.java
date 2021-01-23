package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanAPI;

public class TimestampRequest extends ConsumerRequest<Timestamp> {
	
	public TimestampRequest(BanAPI api) {
		super(api, "time", Timestamp.class);
	}
}
