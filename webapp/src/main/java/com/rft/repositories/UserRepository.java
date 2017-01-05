package com.rft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rft.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	User findByEmail(String email);
	User findByUsernameAndPassword(String username, String password);
	User findById(long id);
	List<User> findAll();
	List<User> findByRole(String role);
	
	 @Query("select id from User x "
	 	   + "where x.id=(select y.userid from Invitations y "
	 	   + "where y.email=(select z.email from User z "
	 	   + "where :id=z.id))")
     long find(@Param("id")  long id);
	 

	
}
