package com.AgricultureApp.LoginServices.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class UserModel {
	@Id
	public String id;
	
	public String name;
	public String role;
	public String password;
	public String getId() {
		return id;
	}
	public UserModel(String id, String name, String role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
