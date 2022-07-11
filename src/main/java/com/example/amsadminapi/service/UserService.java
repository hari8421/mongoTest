package com.example.amsadminapi.service;

import java.util.Base64;
import java.util.List;

import org.modelmapper.ModelMapper;
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
	@Autowired
	private ModelMapper mapper;

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
		String encodedPassWord = Base64.getEncoder().encodeToString(userRequest.getPassWord().getBytes());
		user.setPassWord(encodedPassWord);
		userRepository.save(user);
		UserResponse userResponse = new UserResponse();
		if (user.getEmailId().isEmpty()) {
			throw new CustomException("Email id is a required field");
		} else {
			mapper.map(user, userResponse);
			return userResponse;
		}
	}
}
