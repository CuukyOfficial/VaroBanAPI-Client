package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.VaroBanAPI;

public class TimestampRequest extends ConsumerRequest<Timestamp> {
	
	public TimestampRequest(VaroBanAPI api) {
		super(api, "time", Timestamp.class);
	}
}
