package com.soa.specificationexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soa.specificationexample.dto.UserRequestDTO;
import com.soa.specificationexample.model.User;
import com.soa.specificationexample.repositories.UserRepository;
import com.soa.specificationexample.specification.UserSpecification;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers(UserRequestDTO requestDTO) {
		UserSpecification spec = new UserSpecification(requestDTO);
		return userRepository.findAll(spec);
	}
}
