package com.AgricultureApp.OrderService.resources;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.AgricultureApp.OrderService.Models.Orders;

public interface orderRepository extends MongoRepository<Orders,String> {

	List<Orders> findBydealerID(String dealerID);
	List<Orders> findByfarmerID(String farmerID);

}
