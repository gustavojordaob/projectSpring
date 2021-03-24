package com.estudo.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.couse.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
