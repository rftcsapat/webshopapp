package com.rft.services;

import com.rft.dto.RegformDto;
import com.rft.dto.UserUpdateDto;

public interface UserService {
	
	public abstract void register(RegformDto regformDto);
	public abstract void registerAdmin(RegformDto regformDto);
	public abstract void saveUser(UserUpdateDto userUpdateDto);
	
}
