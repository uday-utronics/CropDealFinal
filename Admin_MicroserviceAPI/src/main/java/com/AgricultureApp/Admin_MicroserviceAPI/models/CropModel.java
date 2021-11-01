package com.AgricultureApp.Admin_MicroserviceAPI.models;




public class CropModel {


	private String farmerId;
	private String cropId;
	private String cropName;
	private String cropLocation;
	private double cropQty;
	private String cropType;
	private String cropImgUrl;
	private String cropDesc;
	private String cropPrice;
	
	
	

	public CropModel(String farmerId, String cropId, String cropName, String cropLocation, double cropQty,
			String cropType, String cropImgUrl, String cropDesc, String cropPrice) {
		super();
		this.farmerId = farmerId;
		this.cropId = cropId;
		this.cropName = cropName;
		this.cropLocation = cropLocation;
		this.cropQty = cropQty;
		this.cropType = cropType;
		this.cropImgUrl = cropImgUrl;
		this.cropDesc = cropDesc;
		this.cropPrice = cropPrice;
	}
	public String getCropImgUrl() {
		return cropImgUrl;
	}
	public void setCropImgUrl(String cropImgUrl) {
		this.cropImgUrl = cropImgUrl;
	}
	public String getCropDesc() {
		return cropDesc;
	}
	public void setCropDesc(String cropDesc) {
		this.cropDesc = cropDesc;
	}
	
	
	public String getCropPrice() {
		return cropPrice;
	}
	public void setCropPrice(String cropPrice) {
		this.cropPrice = cropPrice;
	}

	public CropModel() {
		// TODO Auto-generated constructor stub
	}
	public String getCropId() {
		return cropId;
	}
	public void setCropId(String cropId) {
		this.cropId = cropId;
	}
	public String getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getCropLocation() {
		return cropLocation;
	}
	public void setCropLocation(String cropLocation) {
		this.cropLocation = cropLocation;
	}
	public double getCropQty() {
		return cropQty;
	}
	public void setCropQty(double cropQty) {
		this.cropQty = cropQty;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	
	
}
