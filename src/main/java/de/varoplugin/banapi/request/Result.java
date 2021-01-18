package de.varoplugin.banapi.request;

import com.google.gson.annotations.SerializedName;

public class Result {

	@SerializedName("success")
	private boolean success;
	
	@SerializedName("error")
	private String error;
}
