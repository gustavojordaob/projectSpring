package com.estudo.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.couse.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
}
