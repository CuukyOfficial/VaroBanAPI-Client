package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanApi;

public class TimestampRequest extends ConsumerRequest<Timestamp> {
	
	public TimestampRequest(BanApi api) {
		super(api, "time", Timestamp.class);
	}
}
