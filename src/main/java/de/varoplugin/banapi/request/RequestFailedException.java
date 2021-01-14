package de.varoplugin.banapi.request;

public class RequestFailedException extends Exception {

	private static final long serialVersionUID = 8438417293852217170L;

	RequestFailedException(Throwable cause) {
		super(cause);
	}
	
	RequestFailedException(int code) {
		super(String.format("Unexpected response code %d", code));
	}
}
