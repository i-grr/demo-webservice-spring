package com.udemy.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.udemy.webservices.entities.Order;
import com.udemy.webservices.entities.User;
import com.udemy.webservices.entities.enums.OrderStatus;
import com.udemy.webservices.repositories.OrderRepository;
import com.udemy.webservices.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "999998888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "999977777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2021-02-20T19:52:37Z"), user1, OrderStatus.WAITING_PAYMENT);
		Order order2 = new Order(null, Instant.parse("2021-03-20T21:33:42Z"), user2, OrderStatus.WAITING_PAYMENT);
		Order order3 = new Order(null, Instant.parse("2021-04-20T15:07:02Z"), user1, OrderStatus.WAITING_PAYMENT);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
	}
	
}
