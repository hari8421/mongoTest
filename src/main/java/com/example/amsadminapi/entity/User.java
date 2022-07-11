package com.example.amsadminapi.entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.validation.annotation.Validated;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Validated
public class User {
	
	@Id
	
	
	private String emailId;
	
	private String firstName;
	
	private String lastName;
	
	private String displayName;
	private String userStatus;
	private String created_on;
	
	private String userGroups;
	public String passWord;

	
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}


	public String getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(String userGroups) {
		this.userGroups = userGroups;
	}
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public User(String emailId, String firstName, String lastName, String displayName, String userStatus,
			String created_on, String userGroups, String passWord) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.userStatus = userStatus;
		this.created_on = created_on;
		
		this.userGroups = userGroups;
		this.passWord = passWord;
	}

	public User() {
		super();
	}

	
	
	

	
}
