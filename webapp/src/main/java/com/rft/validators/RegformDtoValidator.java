package com.rft.validators;

import javax.annotation.Resource;
import javax.validation.executable.ExecutableValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.rft.dto.RegformDto;
import com.rft.entities.User;
import com.rft.repositories.UserRepository;

@Component
public class RegformDtoValidator extends LocalValidatorFactoryBean {
	
	private UserRepository userRepository;
	
	@Resource
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(RegformDto.class);
	}

	@Override
	public void validate(Object obj, Errors errors, final Object... validationHints) {
		super.validate(obj, errors, validationHints);
		
		if( ! errors.hasErrors()) {
			RegformDto regformDto = (RegformDto) obj;
			User user = userRepository.findByUsername(regformDto.getUsername());
			if(user != null) {
				errors.rejectValue("username", "Username has already taken.");
			}
			String password = regformDto.getPassword();
			String passwordAgain = regformDto.getPasswordAgain();
			if( ! password.equals(passwordAgain)) {
				errors.rejectValue("password", "Given passwords does not match.");
			}
		}
	}	
	
}
