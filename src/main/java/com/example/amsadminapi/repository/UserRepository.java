package com.example.amsadminapi.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.amsadminapi.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	public ArrayList<User> findByEmailIdAndPassWord(String emailId, String passWord);
}
