package com.example.amsadminapi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.amsadminapi.entity.User;
import com.example.amsadminapi.repository.UserRepository;
import com.example.amsadminapi.request.UserRequest;
import com.example.amsadminapi.response.UserResponse;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;
	@Mock
	UserRepository userRepository;

	@Test
	public void insertUserInfoTest() throws Exception {
		UserRequest userRequest = new UserRequest();
		userRequest.setEmailId("test@gmail.com");
		userRequest.setPassWord("pass");

		UserResponse userResponse = new UserResponse();
		userResponse.setEmailId("test@gmail.com");

		User samplUser = new User();
		samplUser.setEmailId("test@gmail.com");
		// Mockito.when(mapper.map).thenReturn(userResponse);
		// Mockito.when(mapper.map(Mockito.any(User.class),
		// Mockito.any())).thenReturn(userResponse);

		Mockito.when(userRepository.save(Mockito.any())).thenReturn(samplUser);
		UserResponse res = userService.insertUserInfo(userRequest);
		Assert.assertTrue(res.getEmailId().equalsIgnoreCase("test@gmail.com"));
	}
	
	@Test(expected = Exception.class)
	public void insertUserInfoTestWithException() throws Exception {
		UserRequest userRequest = new UserRequest();
		userRequest.setEmailId("test@gmail.com");
		userRequest.setPassWord("pass");
		Mockito.when(userRepository.save(Mockito.any())).thenThrow(Exception.class);
		userService.insertUserInfo(userRequest);
	}

}
