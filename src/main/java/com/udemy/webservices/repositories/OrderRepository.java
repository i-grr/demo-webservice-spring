package com.udemy.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.webservices.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
