package com.AgricultureApp.Payment_MicroserviceAPI.resource;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.AgricultureApp.Payment_MicroserviceAPI.model.paymentModel;


public interface paymentRepository extends MongoRepository<paymentModel,String> {

	
	
	paymentModel findByorderID(String orderId);
}
