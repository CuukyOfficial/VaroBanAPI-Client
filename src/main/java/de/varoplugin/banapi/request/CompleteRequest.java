package de.varoplugin.banapi.request;

import java.util.concurrent.Future;
import java.util.function.Consumer;

import de.varoplugin.banapi.VaroBanAPI;

abstract class CompleteRequest<T> extends AbstractRequest {

	private String payload;
	private Class<T> responseClass;
	
	CompleteRequest(VaroBanAPI api, String url, String payload, Class<T> responseClass) {
		super(api, url);
		this.payload = payload;
		this.responseClass = responseClass;
	}
	
	public T send() throws RequestFailedException {
		return send(this.responseClass, this.payload);
	}
	
	public Future<T> sendAsync() {
		return sendAsync(this.responseClass, this.payload);
	}
	
	public void sendAsync(Consumer<T> callback) {
		sendAsync(this.responseClass, callback, this.payload);
	}
}
