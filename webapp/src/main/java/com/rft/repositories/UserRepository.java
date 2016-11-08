package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rft.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
	User findById(long id);
	List<User> findAll();
	List<User> findByRole(String role);
	
}
