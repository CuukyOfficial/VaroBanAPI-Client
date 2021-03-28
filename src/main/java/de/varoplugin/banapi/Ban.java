package de.varoplugin.banapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ban {

	public static final int DURATION_UNBAN = 0;
	public static final int DURATION_PERMANENT = -1;

	@Expose
	@SerializedName("banID")
	private long id;

	@Expose
	@SerializedName("timestamp")
	private long timestamp;

	@Expose
	@SerializedName("duration")
	private long duration;

	@Expose
	@SerializedName("active")
	private boolean active;

	@Expose
	@SerializedName("operator")
	private String operator;

	@Expose
	@SerializedName("operatorName")
	private String operatorName;

	@Expose
	@SerializedName("reason")
	private String reason;

	@Expose
	@SerializedName("notes")
	private String notes;

	@Expose
	@SerializedName("proof")
	private Proof[] proofs;

	public Ban() {}

	public Ban(long duration, String operator, String operatorName, String reason) {
		this.duration = duration;
		this.operator = operator;
		this.operatorName = operatorName;
		this.reason = reason;
	}

	public long getId() {
		return id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public long getDuration() {
		return duration;
	}

	public boolean isActive() {
		return active;
	}

	public String getOperator() {
		return operator;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public String getReason() {
		return reason;
	}

	public Proof[] getProofs() {
		return proofs;
	}

	public String getNotes() {
		return notes;
	}
}
