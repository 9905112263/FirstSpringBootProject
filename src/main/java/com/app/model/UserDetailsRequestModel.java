package com.app.model;

public class UserDetailsRequestModel {
	
	private String firstName;
	private String lastNname;
	private String email;
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastNname() {
		return lastNname;
	}
	public void setLastNname(String lastNname) {
		this.lastNname = lastNname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
