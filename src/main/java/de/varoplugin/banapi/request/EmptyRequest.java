package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;

abstract class EmptyRequest<T> extends AbstractRequest {

	public EmptyRequest(VaroBanAPI api, String url) {
		super(api, url);
	}
	
	public T send() {
		
	}
	
	public void sendAsync() {
		
	}
}
