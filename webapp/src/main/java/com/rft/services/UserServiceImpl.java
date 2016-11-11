package com.rft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rft.dto.RegformDto;
import com.rft.dto.UserUpdateDto;
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
		user.setId(user.getId());
		user.setTitle(regformDto.getTitle());
//		user.setImage("0x30783132666533343663".getBytes());
		user.setEmail(regformDto.getEmail());
		user.setBirthdate(regformDto.getBirthDate());
		user.setFirstname(regformDto.getFirstname());
		user.setLastname(regformDto.getLastname());
		user.setUsername(regformDto.getUsername());
		user.setPassword(regformDto.getPassword());
		user.setRole("0");
		userRepository.save(user);
		userRepository.flush();
	}

	@Override
	public void registerAdmin(RegformDto regformDto) {
		User user = new User();
		user.setId(user.getId());
		user.setTitle(regformDto.getTitle());
//		user.setImage("0x30783132666533343663".getBytes());
		user.setEmail(regformDto.getEmail());
		user.setBirthdate(regformDto.getBirthDate());
		user.setFirstname(regformDto.getFirstname());
		user.setLastname(regformDto.getLastname());
		user.setUsername(regformDto.getUsername());
		user.setPassword(regformDto.getPassword());
		user.setRole("1");
		userRepository.save(user);
		userRepository.flush();
	}
	
	@Override
	public void saveUser(UserUpdateDto userUpdateDto) {
		User user = userRepository.findByUsername(userUpdateDto.getUsername());
//		user.setId(user.getId());
		user.setTitle(userUpdateDto.getTitle());
//		user.setImage("0x30783132666533343663".getBytes());
		user.setEmail(userUpdateDto.getEmail());
		user.setBirthdate(userUpdateDto.getBirthDate());
		user.setFirstname(userUpdateDto.getFirstname());
		user.setLastname(userUpdateDto.getLastname());
		user.setUsername(userUpdateDto.getUsername());
		user.setPassword(userUpdateDto.getPassword());
		user.setRole("0");
		userRepository.save(user);
		userRepository.flush();
	}
	
}
