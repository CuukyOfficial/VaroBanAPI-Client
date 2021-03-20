package de.varoplugin.banapi;

import com.google.gson.annotations.SerializedName;

public class Proof {

	@SerializedName("proof")
	private String proof;
	
	@SerializedName("proofID")
	private int id;
	
	public Proof() {}
	
	public String getProof() {
		return proof;
	}
	
	public int getId() {
		return id;
	}
}
