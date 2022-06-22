package com.amsadminapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amsadminapi.entity.User;
import com.amsadminapi.request.UserRequest;
import com.amsadminapi.response.UserResponse;
import com.amsadminapi.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/testUser")
	public <T> List<User> testUser() {
		logger.info("Inserting data for testing");
		return userService.findUsers();
	}

	@PostMapping("getuser")
	public ResponseEntity<?> getUserByFirstNameAndLastName(@RequestBody UserRequest userRequest) throws Exception {
		UserResponse response;
		logger.info("in insertCourse controller");
		response = userService.getUserByFirstNameAndLastName(userRequest);
		return ResponseEntity.ok(response);
	}

}
