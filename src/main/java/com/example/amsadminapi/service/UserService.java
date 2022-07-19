package com.example.amsadminapi.service;

import java.util.Base64;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amsadminapi.entity.User;
import com.example.amsadminapi.exception.CustomException;
import com.example.amsadminapi.repository.UserRepository;
import com.example.amsadminapi.request.UserRequest;
import com.example.amsadminapi.response.UserResponse;

@Service
/**
 * 
 * @author 212017
 *
 */
public class UserService {

	@Autowired
	UserRepository userRepository;

	private ModelMapper mapper = new ModelMapper();

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	/**
	 * 
	 * @return
	 */

	public <T> List<User> getUserInfo() {

		return userRepository.findAll();
	}

	/**
	 * 
	 * @return
	 */
	public List<User> deleteUsers() {
		userRepository.deleteAll();
		return userRepository.findAll();
	}

	/**
	 * 
	 * @param userRequest
	 * @return userResponse
	 */
	public UserResponse insertUserInfo(UserRequest userRequest) throws NullPointerException {
		User user = new User();
		mapper.map(userRequest, user);
		logger.info("email{}", user.getEmailId());
		String encodedPassWord = Base64.getEncoder().encodeToString(userRequest.getPassWord().getBytes());
		user.setPassWord(encodedPassWord);
		user = userRepository.save(user);
		UserResponse userResponse = new UserResponse();
		if (user.getEmailId().isEmpty()) {
			throw new CustomException("Email id is a required field");
		} else {
			mapper.map(user, userResponse);
			logger.info("email{}", user.getEmailId());
			logger.info("email{}", userResponse.getEmailId());
			return userResponse;
		}
	}
}
