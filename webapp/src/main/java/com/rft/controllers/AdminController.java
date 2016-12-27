package com.rft.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rft.dto.RegformDto;
import com.rft.entities.Stock;
import com.rft.entities.User;
import com.rft.repositories.AddItemToBasketRepository;
import com.rft.repositories.StockRepository;
import com.rft.repositories.UserRepository;
import com.rft.services.UserService;
import com.rft.validators.RegformDtoValidator;

public class AdminController {
	
	Logger logger = Logger.getLogger(RootController.class);
	
	private UserService userService;
	private RegformDtoValidator regformDtoValidator;
	private UserRepository userRepository;
	private StockRepository stockRepository;
	private AddItemToBasketRepository addItemToBasketRepository;
	
	@Autowired
	public AdminController(UserService userService, RegformDtoValidator regformDtoValidator, 
			UserRepository userRepository, StockRepository stockRepository, AddItemToBasketRepository addItemToBasketRepository) {
		this.userService = userService;
		this.regformDtoValidator = regformDtoValidator;
		this.userRepository = userRepository;
		this.stockRepository = stockRepository;
		this.addItemToBasketRepository = addItemToBasketRepository;
	}
	
	
	@RequestMapping("/admin")
	public String adminLogin() {
		
		return "admin/index";
	}

	@RequestMapping(value="/dashboard", method = GET)
	public String adminDashboard(Model model) throws MessagingException {
		List<User> users = userRepository.findAll();
		List<Stock> products = stockRepository.findAll();
		
		Integer usersCount = users.size();
		Integer productsCount = products.size();
		Random rand = new Random();
		int  r = rand.nextInt(2_000_00) + 1_000_00;
		
		
		model.addAttribute("usersCount", usersCount);
		model.addAttribute("productsCount", productsCount);
		model.addAttribute("monthlyIncome", r);
		return "admin/dashboard";
	}	
	
	@RequestMapping("/admin-logout")
	public String adminLogout() {
		
		return "admin/index";
	}
	
	
	@RequestMapping("/admin-termek")
	public String adminTermek() {
		
		return "admin/product";
	}
	
	@RequestMapping("/admin-raktar")
	public String adminRaktar() {
		
		return "admin/storage";
	}
	
	@RequestMapping("/admin-product-add")
	public String adminProductAdd() {
		
		return "admin/product-add";
	}
	
	@RequestMapping("/admin-product-modified")
	public String adminProductModify() {
		
		return "admin/product-modified";
	}
	
	@RequestMapping(value="/admin-reg", method=GET)
	public String adminRegistration(Model model) {
		model.addAttribute("regformDto", new RegformDto());
		return "admin/admin-registration";
	}
	
}
