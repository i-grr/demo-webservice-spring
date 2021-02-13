package com.udemy.webservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.webservices.entities.User;
import com.udemy.webservices.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		Optional<User> object = userRepository.findById(id);
		return object.get();
	}
	
	public User insert(User object) {
		return userRepository.save(object);
	}
	
}
