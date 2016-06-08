package com.traventure.domain;

public class JsonResponse {
    private String status = null;
    private int length = 0;
    private Object result = null;
    public String getStatus() {
            return status;
    }
    public void setStatus(String status) {
            this.status = status;
    }
    public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Object getResult() {
            return result;
    }
    public void setResult(Object result) {
            this.result = result;
    }
}