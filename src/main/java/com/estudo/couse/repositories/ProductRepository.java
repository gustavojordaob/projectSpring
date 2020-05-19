package com.estudo.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estudo.couse.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
