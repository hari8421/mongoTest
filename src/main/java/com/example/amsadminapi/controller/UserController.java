package com.example.amsadminapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amsadminapi.entity.User;
import com.example.amsadminapi.request.UserRequest;
import com.example.amsadminapi.response.UserResponse;
import com.example.amsadminapi.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * 
 * @author 212017
 *
 */
@RestController
@RequestMapping("/")
@Validated
public class UserController {
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Operation(summary = "Get all users ", description = "Get all the list of users", tags = "CreateAPI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found all the  users") })
	@GetMapping("/getUser")
	public List<User> userInfo() {
		logger.info("Fetching user info from database");
		return userService.getUserInfo();
	}

	@Operation(summary = "Delete all the users ", description = "Delete all the list of users ", tags = "DeleteAPI")
	@DeleteMapping("/deleteUser")
	public <T> List<User> deleteUser() {
		logger.info("Erasing all user info from database");
		return userService.deleteUsers();
	}

	@Operation(summary = "Inserting user data ", description = "Inserting user data in to the database", tags = "CreateAPI")
	@PostMapping("/insertuser")
	public ResponseEntity<?> insertUser(@Valid @RequestBody UserRequest userRequest)
			{
		UserResponse userResponse;
		logger.info("in insertCourse controller");
		userResponse = userService.insertUserInfo(userRequest);
		// return ResponseEntity.ok(userResponse);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}

}
