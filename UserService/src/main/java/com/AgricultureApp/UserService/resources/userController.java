package com.AgricultureApp.UserService.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AgricultureApp.UserService.models.UserModel;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class userController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/Authenticate/{userName}")
	public UserModel authenticate(@PathVariable String userName) {
		
		return userRepository.findByuserName(userName);
		
	}
	
	
	@GetMapping("/getall")
	public List<UserModel> getAll(){
		return userRepository.findAll();
	}
	
	//adding a new user
		@PostMapping("/adduser")
		public UserModel addfarmer(@RequestBody UserModel user) {
			return userRepository.save(user);
		}
		
		
		@GetMapping("/getbyusertype/{userType}")
		public List<UserModel> getUsersByUserType(@PathVariable String userType) {
			return userRepository.getByuserType(userType);
		}
		
		
		@DeleteMapping("delete/{id}")
		public boolean deleteUser(@PathVariable String id) {
			
			userRepository.deleteById(id);
			return true;
		}
		
		@PostMapping("/update/{id}")
		public UserModel update(@PathVariable String id , @RequestBody UserModel user) {
			user.setUserId(id);
			return userRepository.save(user);
		}
	
		@GetMapping("/getbyuseremail/{userEmail}")
		public UserModel getUsersByUserEmail(@PathVariable String userEmail) {
			return userRepository.getByuserEmail(userEmail);
		}
		@GetMapping("getbyid/{id}")
		public Optional<UserModel> getByid(@PathVariable String id) {
			return userRepository.findById(id);
		}
		
	

}
