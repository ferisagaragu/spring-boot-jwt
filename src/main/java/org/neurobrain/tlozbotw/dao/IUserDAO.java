package org.neurobrain.tlozbotw.dao;

import java.util.Optional;

import org.neurobrain.tlozbotw.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDAO extends JpaRepository<User, Long> { 
	
	public Optional<User> findByUserName(String userName);
	public Optional<User> findByEmail(String userName);
	public Optional<User> findByPhoneNumber(String phoneNumber);
	
}