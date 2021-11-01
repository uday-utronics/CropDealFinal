package com.AgricultureApp.LoginServices.resources;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AgricultureApp.LoginServices.models.UserModel;

@RestController
public class LoginController {

	
	@GetMapping("/")
	public Principal test(Principal principal) {
		return principal;
	}
	
	@RequestMapping("/login")
	public Principal home(Principal principal) {
		return principal;
	}
	
	

	@Autowired
	UserRepository UserRepo;

	@RequestMapping("/getall")
	public List<UserModel> getAllData() {	
		  List <UserModel> users = UserRepo.findAll();
		  users.forEach(n->System.out.println(n.name)); 
		  return (users);
	}
	
	
	
	
	
	//this mapping should get a userobject from loginform
	@RequestMapping("/login/{userId}")
	public Boolean UserLogin(@PathVariable("userId") String userId) {	
		UserModel user = UserRepo.findItemByName(userId);
		  //List <UserModel> users = UserRepo.findAll();
		 // users.forEach(n->System.out.println(n.name)); 
		 if(user!=null)
			 return true;
		 else
			 return false;
		
	}
	
	
	//this mapping should receive a userobject from fornt end signup form
	@RequestMapping("/signup")
	public Boolean UserSignup() {
		UserModel user = new UserModel("10009", "SignedUser9", "Dealer","Password234");//hardcoded user
		if(UserRepo.save(user) != null)
			return true;
		else 
			return false;
		
		
	}


}
