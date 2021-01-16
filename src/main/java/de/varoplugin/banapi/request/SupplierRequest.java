package de.varoplugin.banapi.request;

import java.util.concurrent.Future;
import java.util.function.Consumer;

import de.varoplugin.banapi.VaroBanAPI;

abstract class SupplierRequest<T> extends AbstractRequest {

	private Class<T> responseClass;
	
	SupplierRequest(VaroBanAPI api, String url, Class<T> responseClass) {
		super(api, url);
		this.responseClass = responseClass;
	}
	
	public T send() throws RequestFailedException {
		return send(this.responseClass);
	}
	
	public Future<T> sendAsync() {
		return sendAsync(this.responseClass, null);
	}
	
	public void sendAsync(Consumer<T> callback) {
		sendAsync(this.responseClass, callback, null);
	}
}
