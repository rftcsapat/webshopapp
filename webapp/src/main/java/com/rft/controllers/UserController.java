package com.rft.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rft.dto.AddToBasketDto;
import com.rft.dto.UserUpdateDto;
import com.rft.entities.Stock;
import com.rft.entities.User;
import com.rft.repositories.AddItemToBasketRepository;
import com.rft.repositories.StockRepository;
import com.rft.repositories.UserRepository;
import com.rft.services.UserService;
import com.rft.util.Util;
import com.rft.validators.RegformDtoValidator;

public class UserController {
	
	Logger logger = Logger.getLogger(RootController.class);
	
	private UserService userService;
	private RegformDtoValidator regformDtoValidator;
	private UserRepository userRepository;
	private StockRepository stockRepository;
	private AddItemToBasketRepository addItemToBasketRepository;
	
	@Autowired
	public UserController(UserService userService, RegformDtoValidator regformDtoValidator, 
			UserRepository userRepository, StockRepository stockRepository, AddItemToBasketRepository addItemToBasketRepository) {
		this.userService = userService;
		this.regformDtoValidator = regformDtoValidator;
		this.userRepository = userRepository;
		this.stockRepository = stockRepository;
		this.addItemToBasketRepository = addItemToBasketRepository;
	}
	
	@RequestMapping(value="/home/{category}/{pageNumber}", method = GET)
	public String home(@PathVariable String category, @PathVariable Integer pageNumber, 
			Model model, RedirectAttributes redirectAttributes, HttpSession httpSession) {
		if(httpSession.getAttribute("user") == null)  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		
		Page<Stock> items = stockRepository.findAll(new PageRequest(pageNumber, 3));
    	int current = items.getNumber() + 1;
        int begin = Math.max(0, current - 5);
        int end = Math.min(begin + 10, items.getTotalPages()-1);
        
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
    	model.addAttribute("itemsContent", items.getContent());
    	model.addAttribute("items", items);
		
		return "home";
	}
	
	@RequestMapping(value="/logout", method=GET)
	public String logout(RedirectAttributes redirectAttributes, Model model, HttpSession httpSession) {
		httpSession.removeAttribute("user");
		Util.flash(redirectAttributes, "success", "Sikeres kijelentkezés.");
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/product/{productId}", method=GET)
	public String product(@PathVariable("productId") Long productId, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		if(session.getAttribute("user") == null)  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		Stock item = stockRepository.findByItemid(productId);
		model.addAttribute("item", item);
		model.addAttribute("addToBasketDto", new AddToBasketDto());
		return "product/product";
	}
	
	@RequestMapping(value="/product/{productId}", method=POST)
	public String product(Model model, HttpSession session, @PathVariable("productId") Long productId, 
			@ModelAttribute("addToBasketDto") @Valid AddToBasketDto addToBasketDto, 
			BindingResult result,
			RedirectAttributes redirectAttributes
			) {
		if(session.getAttribute("user") == null)  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		Stock item = stockRepository.findByItemid(productId);
		Long ret = -1000L;
		addItemToBasketRepository.addToBasket(
				((User)session.getAttribute("user")).getId(),
				item.getItemid(),
				new Long(addToBasketDto.getQuantity()),
				ret
				);
		
		logger.info(String.valueOf(ret));

		
//		model.addAttribute("item", item);
//		model.addAttribute(new AddToBasketDto());
		return "product/product";
	}
	
	@RequestMapping("/basket")
	public String basket(Model model) {
//		List<>
		return "basket/basket";
	}
	
	@RequestMapping(value="/profil", method=GET)
	public String profil(Model model, HttpSession httpSession, RedirectAttributes redirectAttributes) {
		if(httpSession.getAttribute("user") == null)  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		User user = (User) httpSession.getAttribute("user");
		UserUpdateDto userUpdateDto = new UserUpdateDto();
		userUpdateDto.setTitle(user.getTitle());
		userUpdateDto.setLastname(user.getLastname());
		userUpdateDto.setFirstname(user.getFirstname());
		userUpdateDto.setEmail(user.getEmail());
		userUpdateDto.setBirthDate(user.getBirthdate());
		userUpdateDto.setUsername(user.getUsername());
		userUpdateDto.setPhone(user.getPhone());
		// Ország#Megye#Irányítószám#Város#Utca,Házszám,Emelet,Ajtószám
		String address = user.getAddress();
		String country = "";
		String zipCode = "";
		String settlement = "";
		String streetDetails = "";
		if(address != null) {
			String[] parts = address.split("#");
			int len = parts.length;
			if (len > 0) {
				country = parts[0];
			} 
			if (len > 1) {
				zipCode = parts[1];
			}
			if(len > 2) {
				settlement = parts[2];
			}
			if(len > 3) {
				streetDetails = parts[3];
			}
		}
		userUpdateDto.setCountry(country);
		userUpdateDto.setZipCode(zipCode);
		userUpdateDto.setSettlement(settlement);
		userUpdateDto.setStreetDetails(streetDetails);
		
		model.addAttribute("userUpdateDto", userUpdateDto);
		return "profil/profil";
		
	}
	
	@RequestMapping(value="/profil", method=POST)
	public String profil(@ModelAttribute("userUpdateDto") @Valid UserUpdateDto userUpdateDto, 
			Model model, HttpSession httpSession, RedirectAttributes redirectAttributes) {
		if(httpSession.getAttribute("user") == null)  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		User sessionUser = (User)httpSession.getAttribute("user");
		long loggedInUserId = (sessionUser.getId());
		userUpdateDto.setId(loggedInUserId);
		
		String newPassword      = userUpdateDto.getPassword();
		String newPasswordAgain = userUpdateDto.getPassword();
		if( ! newPassword.equals(newPasswordAgain)) {
			model.addAttribute("passwordError", "A megadott jelszavak nem egyeznek.");
			return "profil/profil";
		} 
		
		if(userUpdateDto.getActualPassword().equals(sessionUser.getPassword()) && ! "".equals(userUpdateDto.getActualPassword())) {
			userUpdateDto.setPassword(newPassword);
		} else {
			Util.flash(redirectAttributes, "danger", "Az adatmódosítás sikertelen. Hibás aktuális jelszó.");
			return "redirect:/profil";
		}
		
		userUpdateDto.setRole(sessionUser.getRole());
		userService.updateUser(userUpdateDto);
		Util.flash(redirectAttributes, "success", "Sikeres adatmódosítás.");
		httpSession.setAttribute("user", Util.userUpdateDtoToEntity(userUpdateDto));
		model.addAttribute("userUpdateDto", userUpdateDto);
//		return "profil/profil";
		return "redirect:/profil";
	}
	
	@RequestMapping("/search-more")
	public String searchMore() {
		
		return "search/search-more";
	}

	@RequestMapping("/credits")
	public String creditsHandler() {
		
		return "profil/credits";
	}

	@RequestMapping("/product-category")
	public String productCategory() {
				
		return "product/product-category";
	}
	
	
	
	@RequestMapping("/search-result")
	public String searchResult() {
		
		return "search/search-result";
	}
	
	
	@RequestMapping("/logout")
	public String logout() {
		
		return "about/about-us";
	}
	
	
	
	@RequestMapping("/orders")
	public String ordersHandler() {
		
		return "basket/orders";
	}
	
}
