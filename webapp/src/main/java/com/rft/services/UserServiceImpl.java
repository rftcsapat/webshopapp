package com.rft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rft.dto.RegformDto;
import com.rft.entities.User;
import com.rft.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void register(RegformDto regformDto) {
		User user = new User();
		user.setBirthdate(regformDto.getBirthDate());
		user.setName(regformDto.getName());
		user.setUsername(regformDto.getUsername());
		user.setPassword(regformDto.getPassword());
		user.setRole("0");
		userRepository.save(user);
	}
	
}
