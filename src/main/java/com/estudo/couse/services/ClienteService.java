package com.estudo.couse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estudo.couse.entities.Cliente;
import com.estudo.couse.repositories.ClienteRepository;
import com.estudo.couse.services.exceptions.DatabaseException;
import com.estudo.couse.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository userRepository;
	
	public List<Cliente> findAll(){
		return userRepository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cliente Insert(Cliente obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new  DatabaseException(e.getMessage());
		}
	}
	
	public Cliente update(Long id, Cliente obj) {
		Cliente entity = userRepository.getOne(id);
		updateData(entity,obj);
		return userRepository.save(entity);
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
		
	}
	
}
