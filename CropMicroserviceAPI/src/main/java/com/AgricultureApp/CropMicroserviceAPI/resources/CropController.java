package com.AgricultureApp.CropMicroserviceAPI.resources;

import java.util.Arrays;
import java.util.List;
import javax.management.AttributeNotFoundException;

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

import com.AgricultureApp.CropMicroserviceAPI.models.CropModel;
import com.AgricultureApp.CropMicroserviceAPI.models.UserModel;
import com.AgricultureApp.CropMicroserviceAPI.services.CropServices;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/crop")
public class CropController {
	
	@Autowired
	CropServices cropServices;
	
	@Autowired
	CropRepository cropRepository;
	
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("")
	public String Test() {
		return "hellowoworld";
	}
	@PostMapping("/addCrop/{farmerId}")
	public String addCrop(@PathVariable String farmerId,@RequestBody CropModel crop) {
		crop.setFarmerId(farmerId);
		if(cropServices.addCrop(crop))
			return ("Added Crop with id"+crop.getCropId()+" with farmer id" + farmerId);
		else
			return("there was an error in adding the crop");
		
	}
	
	@GetMapping("/getall")
	public List<CropModel> getAllCrops(){
		
		return cropServices.getAllCrop();
	}
	
	@GetMapping("/getall/{farmerId}")
	public List<CropModel> getAllCropsByFarmer(@PathVariable String farmerId){
		
		return cropServices.getAllCropByFarmer(farmerId);
	}
	
	@DeleteMapping("/delete/{cropId}")
	public Boolean deleteCrop(@PathVariable String cropId) {
		return cropServices.deleteCrop(cropId);
	}
	
	@PutMapping("/update/{cropId}")
	public String updateByFarmer(@PathVariable String cropId,@RequestBody CropModel crop){
		crop.setCropId(cropId);
		return cropServices.updateCrop(crop);
		
	}
	@GetMapping("/getfarmer/{id}")
	public UserModel getfarmer(@PathVariable String id) {
		return restTemplate.getForObject("http://localhost:8088/getbyid/"+id,UserModel.class);
		
		/*
		 * CropModel ecrop = cropRepository.findCropBycropId(cropId);
		 * ecrop.setCropId(cropId); ecrop.setCropLocation(crop.getCropLocation());
		 * ecrop.setCropName(crop.getCropName()); ecrop.setFarmerId(crop.getFarmerId());
		 * ecrop.setCropQty(crop.getCropQty()); ecrop.setCropType(crop.getCropType());
		 * cropRepository.save(ecrop);
		 */
		
		/*
		 * eCrop.setCropName(crop.getCropName()); eCrop.setFarmerId(crop.getFarmerId());
		 * eCrop.setCropLocation(crop.getCropLocation());
		 * eCrop.setCropQty(crop.getCropQty()); eCrop.setCropType(crop.getCropType());
		 * cropRepository.save(eCrop); return("updated the crop Successfully");
		 */
		
	}
	@GetMapping("/getallfarmer")
	public List<UserModel> getallfarmer() {
		System.out.println("in get all farmer");
		return Arrays.asList(restTemplate.getForObject("http://localhost:8088/getall",UserModel[].class));
		
	
	}
}
