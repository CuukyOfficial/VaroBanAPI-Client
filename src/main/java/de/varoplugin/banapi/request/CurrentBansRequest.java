package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;

public class CurrentBansRequest extends EmptyRequest<T> {
	
	public CurrentBansRequest(VaroBanAPI api) {
		super(api, "currentbans");
	}
}
