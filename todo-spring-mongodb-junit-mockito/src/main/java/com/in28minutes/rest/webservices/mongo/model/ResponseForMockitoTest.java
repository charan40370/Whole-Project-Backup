package com.in28minutes.rest.webservices.mongo.model;



public class ResponseForMockitoTest {

	private String message;
	private boolean status;
	
	public ResponseForMockitoTest(){
		
	}
	
	public ResponseForMockitoTest(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
