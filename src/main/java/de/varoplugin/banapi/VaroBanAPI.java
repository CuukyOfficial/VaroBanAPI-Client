package de.varoplugin.banapi;

import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class VaroBanAPI {

	// Die banAPI fragt alle 30 sek beim Server an und der Server schickt entweder alle changes oder alle daten (mal sehen)

	private final String URL = "https://varoplugin.de/varobanapi/";

	private final String token;
	private Consumer<Throwable> exceptionHandler;
	private final Gson gson;

	public VaroBanAPI(String token, Consumer<Throwable> exceptionHandler) {
		this.token = token;
		this.exceptionHandler = exceptionHandler;
		this.gson = new GsonBuilder().create();
	}
	
	public VaroBanAPI(Consumer<Throwable> exceptionHandler) {
		this(null, exceptionHandler);
	}
	
	public String getURL() {
		return URL;
	}
	
	public String getToken() {
		return token;
	}
	
	public Consumer<Throwable> getExceptionHandler() {
		return exceptionHandler;
	}
	
	public Gson getGson() {
		return gson;
	}
}