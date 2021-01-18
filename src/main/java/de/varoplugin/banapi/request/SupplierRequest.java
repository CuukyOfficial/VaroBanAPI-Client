package de.varoplugin.banapi.request;

import de.varoplugin.banapi.VaroBanAPI;

abstract class SupplierRequest extends AbstractRequest {
	
	private String payload;
	
	SupplierRequest(VaroBanAPI api, String url, String payload) {
		super(api, url);
		this.payload = payload;
	}

	public void send() throws RequestFailedException {
		send(this.payload);
	}
	
	public void sendAsync() {
		sendAsync(this.payload);
	}
	
	public void sendAsync(Runnable callback) {
		sendAsync(this.payload, callback);
	}
}
