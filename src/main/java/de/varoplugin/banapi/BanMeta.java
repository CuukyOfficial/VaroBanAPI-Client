package de.varoplugin.banapi;

import com.google.gson.annotations.SerializedName;

public class BanMeta {

	@SerializedName("banID")
	private long id;
	
	@SerializedName("note")
	private String note;
	
	@SerializedName("proof")
	private String[] proof;
	
	public BanMeta(long id, String note, String... proof) {
		super();
		this.id = id;
		this.note = note;
		this.proof = proof;
	}

	public long getId() {
		return id;
	}
	
	public String getNote() {
		return note;
	}
	
	public String[] getProof() {
		return proof;
	}
}
