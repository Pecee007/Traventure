package com.traventure.domain;

public class userAuth {
	private String status;
	private Object result;
	private String location;

	public userAuth() {
		super();
		this.status = "GUEST";
		this.result = null;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
