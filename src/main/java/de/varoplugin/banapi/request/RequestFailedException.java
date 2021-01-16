package de.varoplugin.banapi.request;

public class RequestFailedException extends Exception {

	private static final long serialVersionUID = 8438417293852217170L;
	
	RequestFailedException(Throwable cause, String url, String payload) {
		super(String.format("url: %s, payload: %s", url, payload), cause);
	}
	
	RequestFailedException(Throwable cause, String url, String payload, String responseBody) {
		super(String.format("url: %s, payload: %s, responsebody: %s", url, payload, responseBody), cause);
	}
	
	RequestFailedException(int code, String url, String payload) {
		super(String.format("Unexpected response code %d, url: %s, payload: %s", code, url, payload));
	}
}
