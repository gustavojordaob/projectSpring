package com.estudo.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.couse.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
