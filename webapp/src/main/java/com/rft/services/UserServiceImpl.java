package com.rft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rft.dto.RegformDto;
import com.rft.dto.UserUpdateDto;
import com.rft.entities.User;
import com.rft.repositories.UserRepository;
import com.rft.util.Util;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void register(RegformDto regformDto, String role) {
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
		user.setAddress("Magyarország###");
		user.setRole(role);
		userRepository.save(user);
		userRepository.flush();
	}
	
	@Override
	public void updateUser(UserUpdateDto userUpdateDto) {
//		User foundUser = userRepository.findById(userUpdateDto.getId());
		User user = Util.userUpdateDtoToEntity(userUpdateDto);
		userRepository.save(user);
		userRepository.flush();
	}
	
}
