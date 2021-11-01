package com.AgricultureApp.UserService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("AppUsers")
public class UserModel {
	
	@Id
	public String userId;

	public  String userName ,userEmail, password,location,accountNo, mobileNo, userType;
	
	

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public UserModel() {
		super();
	}

	

	public UserModel(String userId, String userName, String userEmail, String password, String location,
			String accountNo, String mobileNo, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.location = location;
		this.accountNo = accountNo;
		this.mobileNo = mobileNo;
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	
	
	
	
}
