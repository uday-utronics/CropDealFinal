package com.AgricultureApp.Admin_MicroserviceAPI.models;


public class DealerModel {

	private String id;
	private String dealerName;
	private String dealerUsername;
	private String dealerEmail;
	private String dealerContactNo;
	private String dealerPassword;
	private bankDetails bankDetail;
	
	
	
	public DealerModel() {
		super();
	}
	public DealerModel(String id, String dealerName, String dealerUsername, String dealerEmail, String dealerContactNo,
			String dealerPassword, bankDetails bankDetail) {
		super();
		this.id = id;
		this.dealerName = dealerName;
		this.dealerUsername = dealerUsername;
		this.dealerEmail = dealerEmail;
		this.dealerContactNo = dealerContactNo;
		this.dealerPassword = dealerPassword;
		this.bankDetail = bankDetail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getDealerUsername() {
		return dealerUsername;
	}
	public void setDealerUsername(String dealerUsername) {
		this.dealerUsername = dealerUsername;
	}
	public String getDealerEmail() {
		return dealerEmail;
	}
	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}
	public String getDealerContactNo() {
		return dealerContactNo;
	}
	public void setDealerContactNo(String dealerContactNo) {
		this.dealerContactNo = dealerContactNo;
	}
	public String getDealerPassword() {
		return dealerPassword;
	}
	public void setDealerPassword(String dealerPassword) {
		this.dealerPassword = dealerPassword;
	}
	public bankDetails getBankDetail() {
		return bankDetail;
	}
	public void setBankDetail(bankDetails bankDetail) {
		this.bankDetail = bankDetail;
	}
	
	
}
