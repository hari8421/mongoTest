package com.amsadminapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.amsadminapi.entity.User;

public interface UserRepository extends MongoRepository<User, Long> {

    public List<User> findByFirstName(String firstName);
    public Optional<User> findByFirstNameAndLastName(String firstName,String lastName);

}
