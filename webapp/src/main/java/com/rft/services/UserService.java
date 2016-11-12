package com.rft.services;

import com.rft.dto.RegformDto;
import com.rft.dto.UserUpdateDto;
import com.rft.entities.User;

public interface UserService {
	
	public abstract void register(RegformDto regformDto, String role);
	public abstract void updateUser(UserUpdateDto userUpdateDto);
	
}
