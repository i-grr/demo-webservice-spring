package com.udemy.webservices.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.udemy.webservices.entities.Category;
import com.udemy.webservices.entities.Order;
import com.udemy.webservices.entities.OrderItem;
import com.udemy.webservices.entities.Payment;
import com.udemy.webservices.entities.Product;
import com.udemy.webservices.entities.User;
import com.udemy.webservices.entities.enums.OrderStatus;
import com.udemy.webservices.repositories.CategoryRepository;
import com.udemy.webservices.repositories.OrderItemRepository;
import com.udemy.webservices.repositories.OrderRepository;
import com.udemy.webservices.repositories.ProductRepository;
import com.udemy.webservices.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "999998888", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "999977777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2021-02-20T19:52:37Z"), user1, OrderStatus.WAITING_PAYMENT);
		Order order2 = new Order(null, Instant.parse("2021-03-20T21:33:42Z"), user2, OrderStatus.PAID);
		Order order3 = new Order(null, Instant.parse("2021-04-20T15:07:02Z"), user1, OrderStatus.DELIVERED);
		
		Category category1 = new Category(null, "Eletronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		product1.getCategories().add(category2);
		product2.getCategories().add(category1);
		product2.getCategories().add(category3);
		product3.getCategories().add(category3);
		product4.getCategories().add(category3);
		product5.getCategories().add(category3);
		
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice());
		OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice());
		OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice());
		OrderItem orderItem4 = new OrderItem(order3, product5, 2, product5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
		
		Payment payment1 = new Payment(null, Instant.parse("2021-03-20T23:33:42Z"), order1);
		order1.setPayment(payment1);
		
		orderRepository.save(order1);
		
	}
	
}
