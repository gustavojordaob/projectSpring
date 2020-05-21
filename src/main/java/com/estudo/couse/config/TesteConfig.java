package com.estudo.couse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.couse.entities.Category;
import com.estudo.couse.entities.Order;
import com.estudo.couse.entities.OrderItem;
import com.estudo.couse.entities.Product;
import com.estudo.couse.entities.User;
import com.estudo.couse.entities.enums.OrderStatus;
import com.estudo.couse.repositories.CategoryRepository;
import com.estudo.couse.repositories.OrderItemRepository;
import com.estudo.couse.repositories.OrderRepository;
import com.estudo.couse.repositories.ProductRepository;
import com.estudo.couse.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED ,u1);
		Order o2 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITTING_PAYMENT ,u1);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);
		
		Category c1 = new Category(null,"Informatica");
		Category c2 = new Category(null,"Medico");
		
		Product p1 = new Product(null,"teste ", "teste description ", 10.00,"img teste");
		Product p2 = new Product(null,"teste 2", "teste description 2", 12.00,"img teste2");
		
	
		userRepository.saveAll(Arrays.asList(u1,u2));
		productRepository.saveAll(Arrays.asList(p1,p2));
		categoryRepository.saveAll(Arrays.asList(c1,c2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		
		productRepository.saveAll(Arrays.asList(p1,p2));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p2, 1, p2.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1,oi2));

		
	}
}
