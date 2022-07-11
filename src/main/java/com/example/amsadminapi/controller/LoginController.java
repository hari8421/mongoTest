package com.example.amsadminapi.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amsadminapi.request.LoginRequest;
import com.example.amsadminapi.response.LoginResponse;
import com.example.amsadminapi.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * 
 * @author 212017
 *
 */
@RestController
@RequestMapping("/")

public class LoginController {
	@Autowired
	private LoginService loginservice;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Operation(summary = "login the users by emailID and password ", description = "Login the user by emailId and passWord and getting the user data as response ", tags = "LoginAPI")
	@PostMapping("/login")
	public ResponseEntity<?> getUserByEmailAndPassWord(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
		LoginResponse response;
		logger.info("Fetching user info by email id :{}", loginRequest.getEmailId());
		response = loginservice.getUserByEmailIdAndPassWord(loginRequest);
		return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);

	}
}
