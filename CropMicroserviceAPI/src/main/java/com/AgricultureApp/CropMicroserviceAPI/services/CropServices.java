package com.AgricultureApp.CropMicroserviceAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AgricultureApp.CropMicroserviceAPI.models.CropModel;
import com.AgricultureApp.CropMicroserviceAPI.resources.CropRepository;

@Service
public class CropServices {

	@Autowired
	CropRepository cropRepository;
	
	public Boolean addCrop(CropModel crop) {
		cropRepository.insert(crop);
		return true;
		}

	public List<CropModel> getAllCrop() {
		
		return cropRepository.findAll();
	}

	public List<CropModel> getAllCropByFarmer(String farmerId) 
	{
		return cropRepository.findCropByFarmerId(farmerId);
	}

	public boolean deleteCrop(String cropId) {
		cropRepository.deleteById(cropId);
		return true;
		
	}

	public String updateCrop(CropModel crop) {
		// TODO Auto-generated method stub
		cropRepository.save(crop);
		return "Crop UPdated Successfully";
	}

	/*
	 * public void updateCropByFarmer(String cropId, CropModel crop) {
	 * cropRepository.
	 * 
	 * }
	 */
	
	
	
}
