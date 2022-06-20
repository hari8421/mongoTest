package com.example.amsadminapi;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {

    //Spring converts this to Regex findByFirstnameRegex(String firstname)  {"firstname" : {"$regex" : firstname }}
    // automatically
    public List<User> findByFirstName(String firstName);

}
