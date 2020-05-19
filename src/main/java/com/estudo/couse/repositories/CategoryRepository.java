package com.estudo.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.couse.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
