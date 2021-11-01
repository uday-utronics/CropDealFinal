package com.AgricultureApp.Payment_MicroserviceAPI.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AgricultureApp.Payment_MicroserviceAPI.model.paymentModel;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class paymentController {

	
	@Autowired
	paymentRepository paymentRepository;
	
	
	@PostMapping("/addPayment")
	public void addPayment(@RequestBody paymentModel payment)
	{
		paymentRepository.insert(payment);
	}
	
	@GetMapping("/getAllPayments")
	public List<paymentModel> getPayment()
	{
		return paymentRepository.findAll();
	}
	
	@GetMapping("/getByPaymentId/{orderId}")
	public paymentModel getByPaymentId(@PathVariable String orderId) {
		
		return paymentRepository.findByorderID(orderId);
	}
	
	
}
