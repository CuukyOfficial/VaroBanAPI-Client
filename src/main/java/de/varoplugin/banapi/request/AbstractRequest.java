package de.varoplugin.banapi.request;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import de.varoplugin.banapi.VaroBanAPI;

public abstract class AbstractRequest implements Request {

	private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

	private VaroBanAPI api;
	private String url;

	public AbstractRequest(VaroBanAPI api, String url) {
		this.api = api;
		this.url = url;
	}

	protected <T> T send(Class<T> clazz, String data) throws RequestFailedException {
		String result = this.sendRequest(data);
		return result == null ? null : this.api.getGson().fromJson(result, clazz);
	}
	
	protected void send(String data) throws RequestFailedException {
		this.sendRequest(data);
	}
	
	protected <T> Future<T> sendAsync(Class<T> clazz, String data) {
		return EXECUTOR.submit(() -> {
			try {
				return this.send(clazz, data);
			}catch(RequestFailedException e) {
				handleAsyncException(e);
				return null;
			}
		});
	}

	protected <T> void sendAsync(Class<T> clazz, Consumer<T> consumer, String data) {
		EXECUTOR.execute(() -> {
			try {
				consumer.accept(this.send(clazz, data));
			}catch(RequestFailedException e) {
				handleAsyncException(e);
			}
		});
	}
	
	protected void sendAsync(String data) {
		EXECUTOR.execute(() -> {
			try {
				this.send(data);
			}catch(RequestFailedException e) {
				handleAsyncException(e);
			}
		});
	}
	
	protected void handleAsyncException(Throwable t) {
		Consumer<Throwable> exceptionHandler = this.api.getExceptionHandler();
		if(exceptionHandler != null)
			exceptionHandler.accept(t);
	}
	
	protected String sendRequest(String data) throws RequestFailedException {
		try {
			URL url = new URL(this.url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			if(api.getToken() != null)
				connection.setRequestProperty("Auth-Token", this.api.getToken());

			if(data == null) {
				connection.setRequestMethod("GET");
			}else {
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("Content-Length", String.valueOf(data.length()));
				
				connection.getOutputStream().write(data.getBytes());
			}
			
			if(connection.getResponseCode() == 200)
				return connection.getResponseMessage();
			else
				throw new RequestFailedException(connection.getResponseCode());
		} catch (IOException e) {
			throw new RequestFailedException(e);
		}
	}
}