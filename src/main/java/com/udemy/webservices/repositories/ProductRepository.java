package com.udemy.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.webservices.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
