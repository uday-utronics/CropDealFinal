package com.AgricultureApp.LoginServices.resources;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.AgricultureApp.LoginServices.models.UserModel;

public interface UserRepository extends MongoRepository<UserModel, String> {

	@Query("{name:'?0'}")
    UserModel findItemByName(String name);
}
