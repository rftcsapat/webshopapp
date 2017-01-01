package com.rft.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.hadoop.mapred.gethistory_jsp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rft.dto.ProductSelectDto;
import com.rft.dto.RegformDto;
import com.rft.entities.Stock;
import com.rft.entities.User;
import com.rft.repositories.AddItemToBasketRepository;
import com.rft.repositories.StockRepository;
import com.rft.repositories.UserRepository;
import com.rft.services.UserService;
import com.rft.util.Util;
import com.rft.validators.RegformDtoValidator;

import scala.collection.mutable.HashMap;

@Controller
public class AdminController {
	
	Logger logger = Logger.getLogger(RootController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private RegformDtoValidator regformDtoValidator;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private AddItemToBasketRepository addItemToBasketRepository;
	
	
	@RequestMapping(value="/admin")
	public String adminLogin() {
		
		return "admin/index";
	}

	@RequestMapping(value="/dashboard", method = GET)
	public String adminDashboard(Model model,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}
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
	
	@RequestMapping(value="/admin-logout", method = GET)
	public String adminLogout(RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}
		return "admin/index";
	}
	
	
	@RequestMapping(value="/admin-termek", method = GET)
	public String adminTermek(Model model,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}
		return "admin/product";
	}
	
	@RequestMapping(value="/admin-raktar", method = GET)
	public String adminRaktar(Model model,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}
		return "admin/storage";
	}
	
	@RequestMapping(value="/admin-product-add", method = GET)
	public String adminProductAdd(Model model,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}
		return "admin/product-add";
	}
	
	@RequestMapping(value="/admin-product-modified/{itemId}", method = GET)
	public String adminProductModify(Model model,
//			@ModelAttribute("item") Stock item,
			@PathVariable("itemId") Long itemId,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}
		
		return "admin/product-modified";
	}
	
	@RequestMapping(value="/admin-product-select", method = GET)
	public String adminProductSelect(Model model,
			RedirectAttributes redirectAttributes,
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}
		model.addAttribute("productSelectDto", new ProductSelectDto());
		HashMap<String, String> items = new HashMap<String, String>();
		List<Stock> stockItems = stockRepository.findAll();
		for(Stock item : stockItems) {
			items.put(String.valueOf(item.getItemid()), 
					item.getItemid() + " - " + item.getItemname() + " - " + item.getItemquantity() + " ml");
		}
		model.addAttribute("items", items);
		return "admin/product-select";
	}
	
	@RequestMapping(value="/admin-product-select", method = POST)
	public String adminProductSelect(Model model,
			@ModelAttribute("productSelectDto") ProductSelectDto productSelectDto,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}
//		Stock item = stockRepository.findByItemid(Long.decode(productSelectDto.getItemId()));
//		model.addAttribute("itemId", item);
		return "redirect:/product-modified/" + String.valueOf(productSelectDto.getItemId());
	}
	
	@RequestMapping(value="/admin-reg", method=GET)
	public String adminRegistration(Model model,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}
		model.addAttribute("regformDto", new RegformDto());
		return "admin/admin-registration";
	}
	
	@RequestMapping(value="/admin-reg", method=POST)
	public String adminRegistration(@ModelAttribute("regformDto") @Valid RegformDto regformDto, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		
		if(regformDto == null) 
		{ return "redirect:/dashboard"; }
	
		String password      = regformDto.getPassword();
		String passwordAgain = regformDto.getPasswordAgain();
		
		if(result.hasErrors()) {
			Util.flash(redirectAttributes, "danger", "Hibás formátumú adat található a regisztrációs felületen.");
			return "redirect:/admin-reg";
		} 
		 
		if( ! password.equals(passwordAgain)) {
			model.addAttribute("passwordError", "The given passwords does not match!");
			return "admin/admin-registration";
		}
		
//		if( password.length() < 6) {
//			model.addAttribute("passwordError", "The given passwords must be at least 6 character long!");
//			return "sign/signup";
//		} 
		
		
		User user = userRepository.findByEmail(regformDto.getEmail());
		if(user != null) {
			model.addAttribute("emailError", "E-mail address has already registered.");
			return "admin/admin-registration";
		}
		
		user = userRepository.findByUsername(regformDto.getUsername());
		if(user != null) {
			model.addAttribute("usernameError", "Username has already taken.");
			return "admin/admin-registration";
		}
		
		userService.register(regformDto, "1");
		Util.flash(redirectAttributes, "warning", "Sikeres regisztráció.");
		logger.info(regformDto.toString());
		
		return "redirect:/dashboard";
	}
	
}
