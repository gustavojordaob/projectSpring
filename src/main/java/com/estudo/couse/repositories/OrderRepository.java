package com.estudo.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.couse.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
