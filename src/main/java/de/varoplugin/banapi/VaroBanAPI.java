package de.varoplugin.banapi;

import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.varoplugin.banapi.request.RequestFailedException;

public final class VaroBanAPI {
	
	private static final String DEFAULT_URL = "https://varoplugin.de/varobanapi/";

	private final String url;
	private final String token;
	private final Consumer<RequestFailedException> exceptionHandler;
	private final Gson gson;

	public VaroBanAPI(String url, String token, Consumer<RequestFailedException> exceptionHandler) {
		this.url = url == null ? DEFAULT_URL : url;
		this.token = token;
		this.exceptionHandler = exceptionHandler;
		this.gson = new GsonBuilder().setPrettyPrinting().create();
	}
	
	public VaroBanAPI(Consumer<RequestFailedException> exceptionHandler) {
		this(null, null, exceptionHandler);
	}
	
	public VaroBanAPI() {
		this(null, null, null);
	}
	
	public String getURL() {
		return url;
	}
	
	public String getToken() {
		return token;
	}
	
	public Consumer<RequestFailedException> getExceptionHandler() {
		return exceptionHandler;
	}
	
	public Gson getGson() {
		return gson;
	}
}