package de.varoplugin.banapi.request;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import com.google.gson.JsonSyntaxException;

import de.varoplugin.banapi.BanApi;

public abstract class AbstractRequest implements Request {

	private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

	private BanApi api;
	private String url;

	public AbstractRequest(BanApi api, String url) {
		this.api = api;
		this.url = url;
	}

	protected <T> T send(Class<T> clazz) throws RequestFailedException {
		return this.send(clazz, null);
	}

	protected <T> T send(Class<T> clazz, String data) throws RequestFailedException {
		String result = this.sendRequest(data);

		try {
			return result == null ? null : this.api.getGson().fromJson(result, clazz);
		}catch(JsonSyntaxException e) {
			throw new RequestFailedException(e, getFullUrl(), data, result);
		}
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
			}catch(Throwable t) {
				handleAsyncException(new RequestFailedException(t, getFullUrl(), data));
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
			}catch(Throwable t) {
				handleAsyncException(new RequestFailedException(t, getFullUrl(), data));
			}
		});
	}

	protected void sendAsync(String data) {
		EXECUTOR.execute(() -> {
			try {
				this.send(data);
			}catch(RequestFailedException e) {
				handleAsyncException(e);
			}catch(Throwable t) {
				handleAsyncException(new RequestFailedException(t, getFullUrl(), data));
			}
		});
	}

	protected void sendAsync(String data, Runnable callback) {
		EXECUTOR.execute(() -> {
			try {
				this.send(data);
				callback.run();
			}catch(RequestFailedException e) {
				handleAsyncException(e);
			}catch(Throwable t) {
				handleAsyncException(new RequestFailedException(t, getFullUrl(), data));
			}
		});
	}

	protected void handleAsyncException(RequestFailedException e) {
		Consumer<RequestFailedException> exceptionHandler = this.api.getExceptionHandler();
		if(exceptionHandler != null)
			exceptionHandler.accept(e);
	}

	protected String sendRequest(String payload) throws RequestFailedException {
		try {
			URL url = new URL(this.api.getURL() + this.url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			if(api.getToken() != null)
				connection.setRequestProperty("Auth-Token", this.api.getToken());

			if(payload == null) {
				connection.setRequestMethod("GET");
			}else {
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestProperty("Content-Length", String.valueOf(payload.length()));

				connection.setDoOutput(true);
				connection.getOutputStream().write(payload.getBytes());
			}

			if(connection.getResponseCode() == 200) {
				StringBuilder stringBuilder = new StringBuilder();
				Scanner scanner = new Scanner(connection.getInputStream());
				while(scanner.hasNextLine())
					stringBuilder.append(scanner.nextLine());
				scanner.close();
				connection.disconnect();
				return stringBuilder.toString();
			}else {
				connection.disconnect();
				throw new RequestFailedException(connection.getResponseCode(), this.api.getURL() + this.url, payload);
			}
		} catch (IOException e) {
			throw new RequestFailedException(e, getFullUrl(), payload);
		}
	}

	protected BanApi getApi() {
		return api;
	}

	protected String getFullUrl() {
		return this.api.getURL() + this.url;
	}
}