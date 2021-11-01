package com.AgricultureApp.Admin_MicroserviceAPI.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.AgricultureApp.Admin_MicroserviceAPI.models.CropModel;
import com.AgricultureApp.Admin_MicroserviceAPI.models.DealerModel;
import com.AgricultureApp.Admin_MicroserviceAPI.models.FarmerModel;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("")
	public String Test() {
		return "HelloWorld";
	}

	
	//Everything that An ADMIN can do related to CROP
	//---------------------------------------------------------------------
	@GetMapping("/getAllCrops")
	public List<CropModel> getAllCrops() {
		return Arrays.asList(restTemplate.getForObject("http://CropMicroservice/crop/getall", CropModel[].class));

	}

	@GetMapping("/getAllCropsByFarmer/{farmerId}")
	public List<CropModel> getAllCropsByFarmer(@PathVariable String farmerId) {
		return Arrays.asList(restTemplate.getForObject("http://CropMicroservice/crop/getall/"+farmerId, CropModel[].class));

	}
	
	@DeleteMapping("/deleteCrop/{cropId}")
	public Boolean deleteCropById(@PathVariable String cropId) {
		restTemplate.delete("http://CropMicroservice/crop/delete/" + cropId);
		return true;

	}

	@PostMapping("/addCrop/{farmerId}")
	public String addCrop(@PathVariable String farmerId, @RequestBody CropModel Crop) {
		String msg = restTemplate.postForObject("http://CropMicroservice/crop/addCrop/" + farmerId, Crop, String.class);
		return msg;
	}

	@PutMapping("/updateCrop/{cropId}")
	public Boolean UpdateCrop(@PathVariable String cropId, @RequestBody CropModel Crop) {
		restTemplate.put("http://CropMicroservice/crop/update/" + cropId, Crop);
		return true;
	}

	
	//Everything ADMIN can do related to User
	//-------------------------------------------------------
	
	@GetMapping("/getAllFarmers")
	public List<FarmerModel> getAllFarmers() {
		return Arrays.asList(restTemplate.getForObject("http://Farmer-App/getall", FarmerModel[].class));

	}
	
	@GetMapping("/getFarmer/{farmerName}")
	public FarmerModel getFramerByName(@PathVariable String farmerName) {
		return restTemplate.getForObject("http://Farmer-App/get/"+farmerName, FarmerModel.class);
	}
	
	@PostMapping("/addFarmer")
	public String addFarmer( @RequestBody FarmerModel Farmer) {
		String msg = restTemplate.postForObject("http://Farmer-App/addFarmer/", Farmer, String.class);
		return msg;
	}
	
	@DeleteMapping("/delete/{farmerId}")
	public Boolean deleteFarmerById(@PathVariable String farmerId) {
		restTemplate.delete("http://Farmer-App/delete/" + farmerId);
		return true;

	}
	
	@PostMapping("/updateFarmer/{farmerId}")
	public String UpdateFarmer(@PathVariable String farmerId, @RequestBody FarmerModel Farmer) {
		return restTemplate.postForObject("http://Farmer-App/update/" + farmerId, Farmer,String.class);
	}
	
	//Everything ADMIN can do related to DEALER
	//-------------------------------------------------------

	
	
	
	
}
