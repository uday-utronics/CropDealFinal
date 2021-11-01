package com.AgricultureApp.Admin_MicroserviceAPI.models;

public class FarmerModel {

	private String id;
	private String farmerUsername;
	private String farmerName;
	private String farmerEmail;
	private String farmerContactNo;
	private location farmerLocation;
	private bankDetails bankDetails;
	private String farmerPassword;
	
	public FarmerModel() {
		super();
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFarmerUsername() {
		return farmerUsername;
	}


	public void setFarmerUsername(String farmerUsername) {
		this.farmerUsername = farmerUsername;
	}


	public String getFarmerName() {
		return farmerName;
	}


	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}


	public String getFarmerEmail() {
		return farmerEmail;
	}


	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}


	public String getFarmerContactNo() {
		return farmerContactNo;
	}


	public void setFarmerContactNo(String farmerContactNo) {
		this.farmerContactNo = farmerContactNo;
	}


	public location getFarmerLocation() {
		return farmerLocation;
	}


	public void setFarmerLocation(location farmerLocation) {
		this.farmerLocation = farmerLocation;
	}


	public bankDetails getBankDetails() {
		return bankDetails;
	}


	public void setBankDetails(bankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}


	public String getFarmerPassword() {
		return farmerPassword;
	}


	public void setFarmerPassword(String farmerPassword) {
		this.farmerPassword = farmerPassword;
	}


	public FarmerModel(String id, String farmerUsername, String farmerName, String farmerEmail, String farmerContactNo,
			location farmerLocation, com.AgricultureApp.Admin_MicroserviceAPI.models.bankDetails bankDetails,
			String farmerPassword) {
		super();
		this.id = id;
		this.farmerUsername = farmerUsername;
		this.farmerName = farmerName;
		this.farmerEmail = farmerEmail;
		this.farmerContactNo = farmerContactNo;
		this.farmerLocation = farmerLocation;
		this.bankDetails = bankDetails;
		this.farmerPassword = farmerPassword;
	
}
}