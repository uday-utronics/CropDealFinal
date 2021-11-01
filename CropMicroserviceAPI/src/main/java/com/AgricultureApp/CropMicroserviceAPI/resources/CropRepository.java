package com.AgricultureApp.CropMicroserviceAPI.resources;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.AgricultureApp.CropMicroserviceAPI.models.CropModel;

public interface CropRepository extends MongoRepository<CropModel, String> {

	@Query("{farmerId:'?0'}")
    List<CropModel> findCropByFarmerId(String FarmerId);
	
	CropModel findCropBycropId(String cropId);
}
