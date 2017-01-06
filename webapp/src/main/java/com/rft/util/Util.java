package com.rft.util;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rft.dto.UserUpdateDto;
import com.rft.entities.User;

public class Util {
	
	private static MessageSource messageSource;
	
	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		Util.messageSource = messageSource;
	}
	
	public static void flash(RedirectAttributes redirectAttributes, String kind, String message) {
		redirectAttributes.addFlashAttribute("flashKind", kind);
		redirectAttributes.addFlashAttribute("flashMessage", message);
	}
	
	private static String getMessage(String messageKey, Object... args) {
		return messageSource.getMessage(messageKey, args, Locale.getDefault());
	}
	
	public static String getAddressFromDto(UserUpdateDto dto) {
		return String.format("%s#%s#%s#%s", dto.getCountry(), dto.getZipCode(), dto.getSettlement(), dto.getStreetDetails());
	}
	
	public static User userUpdateDtoToEntity(UserUpdateDto dto) {
		User user = new User();
		user.setAddress(getAddressFromDto(dto));
		user.setBirthdate(dto.getBirthDate());
		user.setCoins(dto.getCoins());
		user.setEmail(dto.getEmail());
		user.setFirstname(dto.getFirstname());
		user.setId(dto.getId());
		user.setInvitedby(dto.getInvitedby());
		user.setLastname(dto.getLastname());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setPhone(dto.getPhone());
		user.setRole(dto.getRole());
		return user;
	}
	
}
