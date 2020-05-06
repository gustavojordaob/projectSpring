package com.estudo.couse.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.couse.entities.User;

@RestController
@RequestMapping(value =	"/users")
public class UserResources {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(1L, "Maria", "maria@gmail.com","999999999","123123");
		return ResponseEntity.ok().body(user);
	}
}
