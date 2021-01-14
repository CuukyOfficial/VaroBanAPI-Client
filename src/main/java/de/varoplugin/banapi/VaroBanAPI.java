package de.varoplugin.banapi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class VaroBanAPI {

	// Die banAPI fragt alle 30 sek beim Server an und der Server schickt entweder alle changes oder alle daten (mal sehen)

	private static final String URL = "https://varoplugin.de/VaroBanAPI";

	private final String token;

	private final RequestHandler requestHandler;
	private final ExecutorService threadPool;

	private final Gson gson;

	public VaroBanAPI() {
		this(null);
	}

	public VaroBanAPI(String token) {
		this.token = token;

		this.requestHandler = new RequestHandler(URL);
		this.threadPool = Executors.newCachedThreadPool();
		this.gson = new GsonBuilder().create();
	}

	protected <T> void sendRequestAsync(Class<T> clazz, Consumer<T> consumer, int code, String postData) {
		threadPool.execute(() -> {
			consumer.accept(this.sendRequest(clazz, code, postData));
		});
	}

	protected <T> T sendRequest(Class<T> clazz, int code, String postData) {
		String result = this.requestHandler.sendRequest(this.token, code, postData);
		return result == null ? null : this.gson.fromJson(result, clazz);
	}
}