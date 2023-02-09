package com.roles.permission.exception;


public class ErrorMessage {
	public ErrorMessage(String message, String messageKey) {
		super();
		this.message = message;
		this.messageKey = messageKey;
	}
	private String message;
	private String messageKey;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageKey() {
		return messageKey;
	}
	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
