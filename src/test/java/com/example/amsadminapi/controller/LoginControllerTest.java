package com.example.amsadminapi.controller;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.amsadminapi.request.LoginRequest;
import com.example.amsadminapi.response.LoginResponse;
import com.example.amsadminapi.service.LoginService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@InjectMocks
	private LoginController loginControllerObj;

	@Mock
	private LoginService serviceMock;

	@Test
	public void testAdd() throws Exception {
		LoginResponse response=new LoginResponse();
		response.setEmailId("test@gmail.com");
		LoginRequest req=new LoginRequest();
		req.setEmailId("test@gmail.com");
		req.setPassWord("testPwd");
		// add the behavior of calc service to add two numbers
		when(serviceMock.getUserByEmailIdAndPassWord(Mockito.any())).thenReturn(response);
        ResponseEntity<?> res=loginControllerObj.getUserByEmailAndPassWord(req);
		// test the add functionality
		Assert.assertEquals(((LoginResponse)res.getBody()).getEmailId(),("test@gmail.com"));
	}

}
