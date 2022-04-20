package com.app.ui.model.response;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	private String message;

	public Date getTimestamp() {
		return timestamp;
	}

	public ErrorMessage() {
		
	}
	
	public ErrorMessage(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
