package com.udemy.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.webservices.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
