package com.example.amsadminapi.service;

import java.util.ArrayList;
import java.util.Base64;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amsadminapi.controller.LoginController;
import com.example.amsadminapi.entity.User;
import com.example.amsadminapi.exception.CustomException;
import com.example.amsadminapi.repository.UserRepository;
import com.example.amsadminapi.request.LoginRequest;
import com.example.amsadminapi.response.LoginResponse;

/**
 * 
 * @author 212017
 *
 */
@Service
public class LoginService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * 
	 * @param loginRequest
	 * @return response
	 */
	public LoginResponse getUserByEmailIdAndPassWord(LoginRequest loginRequest) throws Exception {
		LoginResponse response = new LoginResponse();
		try {
			logger.info("Inside getUserByEmailIdAndPassWord with user:{}", loginRequest.getEmailId());
			String decryptPassWord = Base64.getEncoder().encodeToString(loginRequest.getPassWord().getBytes());

			ArrayList<User> userinfo = userRepository.findByEmailIdAndPassWord(loginRequest.getEmailId(),
					decryptPassWord);

			if (userinfo.size() > 0) {
				mapper.map(userinfo.get(0), response);
				response.setErrorMsg("Success");
			} else { // response.setErrorMsg("Incorrect Details");
				throw new CustomException("Not a valid user");
			}
		} catch (Exception e) {
			logger.error("Exception while calling getUserByEmailIdAndPassWord with user :{}", loginRequest.getEmailId(),
					e);
			throw e;
		}
		return response;
	}

}
