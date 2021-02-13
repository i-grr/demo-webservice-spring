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
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User object) {
		User entity = userRepository.getOne(id);
		updateData(entity, object);
		return userRepository.save(entity);
	}

	private void updateData(User entity, User object) {
		entity.setName(object.getName());
		entity.setEmail(object.getEmail());
		entity.setPhone(object.getPhone());
	}
	
}
