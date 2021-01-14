package de.varoplugin.banapi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class RequestHandler {

	private String url;

	public RequestHandler(String url) {
		this.url = url;
	}

	public String sendRequest(String token, int code, String postData) {
		try {
			URL url = new URL(this.url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("POST");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}