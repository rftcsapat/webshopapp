package com.rft.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rft.dto.LoginDto;
import com.rft.dto.RegformDto;
import com.rft.dto.UserUpdateDto;
import com.rft.entities.User;
import com.rft.repositories.UserRepository;
import com.rft.services.UserService;
import com.rft.util.Util;
import com.rft.validators.RegformDtoValidator;

import scala.annotation.meta.setter;

@Controller
public class RootController {
	
	Logger logger = Logger.getLogger(RootController.class);
	
	private UserService userService;
	private RegformDtoValidator regformDtoValidator;
	private UserRepository userRepository;
	
	@Autowired
	public RootController(UserService userService, RegformDtoValidator regformDtoValidator, UserRepository userRepository) {
		this.userService = userService;
		this.regformDtoValidator = regformDtoValidator;
		this.userRepository = userRepository;
	}
	
//	@InitBinder("regformDtoValidator")
//	protected void initRegformDtoValidator(WebDataBinder binder) {
//		binder.setValidator(regformDtoValidator);
//	}
	
	@RequestMapping(value = "/register", method = GET)
	public String register(Model model) {
		RegformDto regdto = new RegformDto();
		regdto.setName("Valaki");
		model.addAttribute("name", "EgyNév");
		model.addAttribute("regformDto", regdto);
		return "register";
	}
	
	@RequestMapping(value = "/register", method = POST)
	public String register(@ModelAttribute("regformDto") @Valid RegformDto regformDto, BindingResult result, 
			RedirectAttributes redirectAttributes, Model model) {
		
		if(regformDto == null) 
			{ return "redirect:/"; }
		
		String password      = regformDto.getPassword();
		String passwordAgain = regformDto.getPasswordAgain();
		
		if(result.hasErrors()) {
			return "redirect:/";
		} else if( ! password.equals(passwordAgain)) {
			model.addAttribute("passwordError", "The given passwords does not match!");
			return "register";
		} 
		
		User user = userRepository.findByUsername(regformDto.getUsername());
		if(user != null) {
			model.addAttribute("usernameError", "Username has already taken.");
			return "register";
		}
		
		userService.register(regformDto);
		Util.flash(redirectAttributes, "warning", "Signup successful. Check your email box.");
		logger.info(regformDto.toString());
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = GET)
	public String login(Model model) {
		model.addAttribute("loginDto", new LoginDto());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = POST)
	public String login(@ModelAttribute("loginDto") @Valid LoginDto loginDto, BindingResult result, Model model, RedirectAttributes redir) {
		if(result.hasErrors()) {
			model.addAttribute("loginError", "Something went wrong.");
			return "login";
		}
		
		User user = userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		if(user == null) {
			model.addAttribute("loginError", "Login failed... cuz'");
			return "login";
		} else {
			if(user.getRole().equals("0")) {
				UserUpdateDto dto = new UserUpdateDto();
				dto.setBirthDate(user.getBirthdate());
				dto.setName(user.getName());
//				dto.setPassword(user.getPassword());
//				dto.setPasswordAgain(user.getPassword());
				dto.setUsername(user.getUsername());
				redir.addAttribute("userUpdateDto", dto);
				model.addAttribute("userUpdateDto", dto);
//				return "redirect:/user";
				return "user";
			} else {
				return "admin";
			}
		}
	}
	
//	@RequestMapping(value = "/user", method = GET)
//	public String user(Model model,
//			@ModelAttribute("userUpdateDto") UserUpdateDto userUpdateDto
//			) {
//		model.addAttribute("userUpdateDto", userUpdateDto);
//		return "user";
//	}
	
//	@RequestMapping(value = "/user", method = POST)
//	public String user(@ModelAttribute("userUpdateDto") @Valid UserUpdateDto userUpdateDto, BindingResult result, Model model) {
////		logger.info(userUpdateDto);
//		return "user";
//	}
	
	
	@RequestMapping(value = "/admin", method = GET)
	public String admin(Model model) {
		model.addAttribute("regformDto", new RegformDto());
		return "admin";
	}
	
	
}
