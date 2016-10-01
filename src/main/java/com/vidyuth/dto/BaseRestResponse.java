package com.vidyuth.dto;

public class BaseRestResponse {
	
	public BaseRestResponse() {
		super();
	}
	private int responseCode;
	private String responseMessage;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public BaseRestResponse(int responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	

}
