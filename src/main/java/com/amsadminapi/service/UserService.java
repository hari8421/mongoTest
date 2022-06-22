package com.amsadminapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsadminapi.entity.User;
import com.amsadminapi.repository.UserRepository;
import com.amsadminapi.request.UserRequest;
import com.amsadminapi.response.UserResponse;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;

	public List<User> findUsers() {
		User user = new User(1L, "TEST1", "TEST");
		User user1 = new User(2L, "TEST2", "TEST");
		User user2 = new User(3L, "TEST3", "TEST");
		List<User> userList=new ArrayList<User>();
		userList.add(user);
		userList.add(user1);
		userList.add(user2);
		userRepository.saveAll(userList);
		return userRepository.findAll();
	}

	public UserResponse getUserByFirstNameAndLastName(UserRequest userRequest) {
		Optional<User> user=userRepository.findByFirstNameAndLastName(userRequest.getFirstName(), userRequest.getLastName());
		UserResponse response=new UserResponse();
		if(user.isPresent()) {
			mapper.map(user.get(), response);
		}else {
			response.setErrorMsg("Invalid user");
		}
		return response;	
	}

}
