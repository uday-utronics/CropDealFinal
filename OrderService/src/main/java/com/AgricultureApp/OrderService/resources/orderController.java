package com.AgricultureApp.OrderService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AgricultureApp.OrderService.Models.Orders;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class orderController {
	
	@Autowired
	private orderRepository orderRepository;
	
	
	@PostMapping("/addOrder")
	public Orders addOrder(@RequestBody Orders order) {
		
		return orderRepository.save(order);
		
	}
	
	@GetMapping("/getAllOrder")
	public List<Orders> getAllOrder() {
		
		return orderRepository.findAll();
		
	}
	@GetMapping("/getOrderByFarmer/{farmerID}")
	public List<Orders> getOrderByFarmer(@PathVariable String farmerID) {
		
		return orderRepository.findByfarmerID(farmerID);
		
	}
	@GetMapping("/getOrderByDealer/{dealerID}")
	public List<Orders> getOrderByDealer(@PathVariable String dealerID) {
		
		return orderRepository.findBydealerID(dealerID);
		
	}

}
