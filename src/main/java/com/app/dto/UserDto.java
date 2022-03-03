package com.app.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
 
 
 private static final long serialVersionUID = -3244394309083298628L;
 private long id;
 private String userId;
 private String firstName;
 private String lastNname;
 private String email;
 private String encryptedPassword;
 private String emailVerificationToken;
 private boolean emailVerificationStatus=false;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
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
public String getEncryptedPassword() {
	return encryptedPassword;
}
public void setEncryptedPassword(String encryptedPassword) {
	this.encryptedPassword = encryptedPassword;
}
public String getEmailVerificationToken() {
	return emailVerificationToken;
}
public void setEmailVerificationToken(String emailVerificationToken) {
	this.emailVerificationToken = emailVerificationToken;
}
public boolean isEmailVerificationStatus() {
	return emailVerificationStatus;
}
public void setEmailVerificationStatus(boolean emailVerificationStatus) {
	this.emailVerificationStatus = emailVerificationStatus;
}
}
