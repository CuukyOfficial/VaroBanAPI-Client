package de.varoplugin.banapi.request;

import de.varoplugin.banapi.Timestamp;
import de.varoplugin.banapi.BanApi;

public class LatestDiscordBansRequest extends BansRequest {
	
	public LatestDiscordBansRequest(BanApi api, Timestamp timestamp) {
		super(api, "dc/latest", timestamp);
	}
	
	public LatestDiscordBansRequest(BanApi api, long timestamp) {
		super(api, "dc/latest", timestamp);
	}
	
	public LatestDiscordBansRequest(BanApi api) {
		super(api, "dc/latest");
	}
}
