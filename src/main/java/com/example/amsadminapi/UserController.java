package com.example.amsadminapi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/testUser")
	public <T> List<User> getCandidateFromConsultancy() {
		logger.info("Contacting consultancy");
		User user = new User(1L, "TEST*", "TEST");
		userRepository.save(user);
		return userRepository.findAll();
	}

}
