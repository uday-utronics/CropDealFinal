package com.AgricultureApp.Admin_MicroserviceAPI.resources;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.AgricultureApp.Admin_MicroserviceAPI.models.CropModel;

class AdminControllerTest {

	@InjectMocks
	AdminController adminController;
	@Mock
	RestTemplate restTemplate;
	
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
	void testGetAllCrops() {
		/*
		 * List<CropModel> testCrops = new ArrayList<CropModel>(); testCrops.add(new
		 * CropModel()); when(adminController.getAllCrops()).thenReturn(testCrops);
		 * 
		 * List<CropModel> result = adminController.getAllCrops();
		 * Assertions.assertThatObject(result);
		 */
	}

	@Test
	void testGetAllCropsByFarmer() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCropById() {
		fail("Not yet implemented");
	}

	@Test
	void testAddCrop() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateCrop() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllFarmers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetFramerByName() {
		fail("Not yet implemented");
	}

	@Test
	void testAddFarmer() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteFarmerById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateFarmer() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllDealers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDealerByName() {
		fail("Not yet implemented");
	}

	@Test
	void testAddDealer() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteDealerById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateDealer() {
		fail("Not yet implemented");
	}

}
