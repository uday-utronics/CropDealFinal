package com.AgricultureApp.UserService.resources;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.AgricultureApp.UserService.models.UserModel;



public interface UserRepository extends  MongoRepository<UserModel,String> {

	@Query("{'userType':?0}")
	List<UserModel> getByuserType(String userType);

	@Query("{'userEmail':?0}")
	UserModel getByuserEmail(String userEmail);

	@Query("{'userName':?0,'userPassword':?1}")
	UserModel authenticate(String userName, String password);
	
	UserModel findByuserName(String userName);

}
