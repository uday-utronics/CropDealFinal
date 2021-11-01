package com.AgricultureApp.CropMicroserviceAPI.resources;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.AgricultureApp.CropMicroserviceAPI.models.CropModel;
import com.AgricultureApp.CropMicroserviceAPI.services.CropServices;
import com.mongodb.assertions.Assertions;


class CropControllerTest {

	@InjectMocks
	CropController controller;
	
	@Mock
	CropServices cropServices;
	
	@BeforeEach
	void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void testTest() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCrop() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllCrops() {
		List<CropModel> testCrops = new ArrayList<CropModel>();
		testCrops.add(new CropModel());
		when(controller.getAllCrops()).thenReturn(testCrops);
		
		List<CropModel> result = controller.getAllCrops();
		
		Assertions.assertNotNull(result);
		
	}

	@Test
	void testGetAllCropsByFarmer() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCrop() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateByFarmer() {
		fail("Not yet implemented");
	}

}
