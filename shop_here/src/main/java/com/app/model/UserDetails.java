package com.app.model;

public class UserDetails {

	private int userId;
	private String userFirstName;
	private String userLastName;
	private long userContact;
	private long userCardNo;
	private String userEmail;
	private String userPassword;
	public UserDetails() {}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public long getUserContact() {
		return userContact;
	}
	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}
	public long getUserCardNo() {
		return userCardNo;
	}
	public void setUserCardNo(long userCardNo) {
		this.userCardNo = userCardNo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userContact=" + userContact + ", userCardNo=" + userCardNo + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + "]";
	}

	public UserDetails(int userId, String userFirstName, String userLastName, long userContact, long userCardNo,
			String userEmail, String userPassword) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userContact = userContact;
		this.userCardNo = userCardNo;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	
}	
