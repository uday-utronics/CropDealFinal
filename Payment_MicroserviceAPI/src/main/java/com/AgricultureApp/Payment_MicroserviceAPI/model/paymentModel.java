package com.AgricultureApp.Payment_MicroserviceAPI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Payments")
public class paymentModel {

	@Id
	private String paymentID;
	private String orderID;
	private String orderName;
	private String paymentTo;
	private String paymentFrom;
	private String paymentAmount;
	
	
	
	public paymentModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public paymentModel(String paymentID, String orderID, String orderName, String paymentTo, String paymentFrom,
			String paymentAmount) {
		super();
		this.paymentID = paymentID;
		this.orderID = orderID;
		this.orderName = orderName;
		this.paymentTo = paymentTo;
		this.paymentFrom = paymentFrom;
		this.paymentAmount = paymentAmount;
	}



	public String getPaymentID() {
		return paymentID;
	}



	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}



	public String getOrderID() {
		return orderID;
	}



	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}



	public String getOrderName() {
		return orderName;
	}



	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}



	public String getPaymentTo() {
		return paymentTo;
	}



	public void setPaymentTo(String paymentTo) {
		this.paymentTo = paymentTo;
	}



	public String getPaymentFrom() {
		return paymentFrom;
	}



	public void setPaymentFrom(String paymentFrom) {
		this.paymentFrom = paymentFrom;
	}



	public String getPaymentAmount() {
		return paymentAmount;
	}



	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}	
	
	
	
	
	
}
