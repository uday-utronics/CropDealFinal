package com.AgricultureApp.OrderService.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Orders")
public class Orders {
	@Id
	private String orderID;
	private String dealerID;
	private String farmerID;
	private String cropID;
	private String dealerName;
	private String farmerName;
	private String cropName;
	private String dealerMobile;
	private String farmerMobile;
	private String orderStatus;
	
	
	public Orders() {
		super();
	}

	


	public Orders(String orderID, String dealerID, String farmerID, String cropID, String dealerName, String farmerName,
			String cropName, String dealerMobile, String farmerMobile, String orderStatus) {
		super();
		this.orderID = orderID;
		this.dealerID = dealerID;
		this.farmerID = farmerID;
		this.cropID = cropID;
		this.dealerName = dealerName;
		this.farmerName = farmerName;
		this.cropName = cropName;
		this.dealerMobile = dealerMobile;
		this.farmerMobile = farmerMobile;
		this.orderStatus = orderStatus;
	}




	public String getCropName() {
		return cropName;
	}




	public void setCropName(String cropName) {
		this.cropName = cropName;
	}




	public String getDealerName() {
		return dealerName;
	}


	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}


	public String getFarmerName() {
		return farmerName;
	}


	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}


	public String getDealerMobile() {
		return dealerMobile;
	}


	public void setDealerMobile(String dealerMobile) {
		this.dealerMobile = dealerMobile;
	}


	public String getFarmerMobile() {
		return farmerMobile;
	}


	public void setFarmerMobile(String farmerMobile) {
		this.farmerMobile = farmerMobile;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getDealerID() {
		return dealerID;
	}
	public void setDealerID(String dealerID) {
		this.dealerID = dealerID;
	}
	public String getFarmerID() {
		return farmerID;
	}
	public void setFarmerID(String farmerID) {
		this.farmerID = farmerID;
	}
	public String getCropID() {
		return cropID;
	}
	public void setCropID(String cropID) {
		this.cropID = cropID;
	}
	
	

}
