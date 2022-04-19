package com.app.ui.model.response;

public enum ErrorMessages {
   
	MISSING_REQUIRED_FIELD("Missing Required Fied. Please check documentation for required field"),
	RECORD_AREADY_EXISTS("Record Already Exists"),
	INTERNAL_SERVER_ERROR("Internal Server Error"),
	NO_RECORD_FOUND("Record with provided id is not found"),
	AUTHENTICATION_FAILED("Authentication Failed"),
	COULD_NOT_UPDATE_RECORD("Could Not Update Record"),
	COULD_NOT_DELETE_RECORD("Could Not Delete Record"),
	EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified");
	
	
	private String errorMessage;
	ErrorMessages(String errorMessage) {
		// TODO Auto-generated constructor stub
		this.errorMessage=errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
