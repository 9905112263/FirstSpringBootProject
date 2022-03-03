package com.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity(name="users")
public class UserEntity implements Serializable {


	private static final long serialVersionUID = -3277660761298763758L;
	@Id
	@GeneratedValue
	 private long id;
	
	 @Column(nullable=false,length=50)
	 private String userId;
	 
	 @Column(nullable=false,length=50)
	 private String firstName;
	 
	 @Column(nullable=false,length=50)
	 private String lastNname;
	 
	 @Column(nullable=false,length=120)
	 private String email;
	 
	 @Column(nullable=false)
	 private String encryptedPassword;
	 
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

	public boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

	private String emailVerificationToken;
	 
	 @Column(nullable=false)
	 private boolean emailVerificationStatus=false;
	

}
