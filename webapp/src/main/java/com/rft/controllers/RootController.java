package com.rft.controllers;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rft.dto.AddToBasketDto;
import com.rft.dto.LoginDto;
import com.rft.dto.RegformDto;
import com.rft.dto.UserUpdateDto;
import com.rft.entities.Stock;
import com.rft.entities.User;
import com.rft.repositories.AddItemToBasketRepository;
import com.rft.repositories.StockRepository;
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
	private StockRepository stockRepository;
	private AddItemToBasketRepository addItemToBasketRepository;
	
	@Autowired
	public RootController(UserService userService, RegformDtoValidator regformDtoValidator, 
			UserRepository userRepository, StockRepository stockRepository, AddItemToBasketRepository addItemToBasketRepository) {
		this.userService = userService;
		this.regformDtoValidator = regformDtoValidator;
		this.userRepository = userRepository;
		this.stockRepository = stockRepository;
		this.addItemToBasketRepository = addItemToBasketRepository;
	}
	
//	@InitBinder("regformDtoValidator")
//	protected void initRegformDtoValidator(WebDataBinder binder) {
//		binder.setValidator(regformDtoValidator);
//	}
	
	
	
	@RequestMapping(value = "/register", method = GET)
	public String register(Model model) {
		RegformDto regdto = new RegformDto();
//		model.addAttribute("name", "EgyNév");
		model.addAttribute("regformDto", regdto);
		return "register";
	}
	
	
	
	@RequestMapping(value = "/register", method = POST)
	public String register(@ModelAttribute("regformDto") @Valid RegformDto regformDto, BindingResult result, 
			RedirectAttributes redirectAttributes, Model model) {
		
		if(regformDto == null) { 
			return "redirect:/"; 
		}
		
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
		
		userService.register(regformDto, "0");
		Util.flash(redirectAttributes, "success", "Signup successful.");
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
				dto.setFirstname(user.getFirstname());
				dto.setLastname(user.getLastname());
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
	
	
/*	@RequestMapping(value = "/admin", method = GET)
	public String admin(Model model) {
		model.addAttribute("regformDto", new RegformDto());
		return "admin";
	}*/
	
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
	
	@RequestMapping("/")
	public String about() {
		
		return "about/about-us";
		
	}
	
	@RequestMapping(value ="/signin", method = GET)
	public String signIn(Model model, HttpSession httpSession) {
		model.addAttribute("loginDto", new LoginDto());
		return "sign/signin";
		
	}
	
	@RequestMapping(value ="/signin", method = POST)
	public String signIn(@ModelAttribute("loginDto") @Valid LoginDto loginDto, BindingResult result, Model model,  HttpSession httpSession,
			RedirectAttributes redirectAttributes) {
		User user = userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		if(user == null) {
			model.addAttribute("loginError", "Hibás felhasználónév vagy jelszó.");
		} else {
			httpSession.setAttribute("user", user);
			String role = user.getRole();
			switch(role) {
				case "0":
					return "redirect:/home/all/0";
				case "1":
					return "redirect:/dashboard";
				case "-1":
					Util.flash(redirectAttributes, "danger", "Törölt regisztráció.");
					return "redirect:/";
			}
		}
		
		return "sign/signin";
	}
	
	@RequestMapping(value="/signup", method=GET)
	public String signUp(Model model) {
		model.addAttribute("regformDto", new RegformDto());
		return "sign/signup";
	}
	
	@RequestMapping(value="/signup", method=POST)
	public String signUp(@ModelAttribute("regformDto") @Valid RegformDto regformDto, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		if(regformDto == null) 
		{ return "redirect:/"; }
	
		String password      = regformDto.getPassword();
		String passwordAgain = regformDto.getPasswordAgain();
		
		if(result.hasErrors()) {
			Util.flash(redirectAttributes, "danger", "Hibás formátumú adat található a regisztrációs felületen.");
			return "redirect:/signup";
		} 
		
		if( ! password.equals(passwordAgain)) {
			model.addAttribute("passwordError", "The given passwords does not match!");
			return "sign/signup";
		}
		
//		if( password.length() < 6) {
//			model.addAttribute("passwordError", "The given passwords must be at least 6 character long!");
//			return "sign/signup";
//		} 
		
		
		User user = userRepository.findByEmail(regformDto.getEmail());
		if(user != null) {
			model.addAttribute("emailError", "E-mail address has already registered.");
			return "sign/signup";
		}	
		
		user = userRepository.findByUsername(regformDto.getUsername());
		if(user != null) {
			model.addAttribute("usernameError", "Username has already taken.");
			return "sign/signup";
		}
		
		userService.register(regformDto, "0");
		Util.flash(redirectAttributes, "warning", "Sikeres regisztráció.");
		logger.info(regformDto.toString());
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=GET)
	public String logout(RedirectAttributes redirectAttributes, Model model, HttpSession httpSession) {
		httpSession.removeAttribute("user");
		Util.flash(redirectAttributes, "success", "Sikeres kijelentkezés.");
		return "redirect:/";
		
	}
	
	@RequestMapping("/product-category")
	public String productCategory() {
				
		return "product/product-category";
	}
	
	@RequestMapping(value="/product/{productId}", method=GET)
	public String product(@PathVariable("productId") Long productId, Model model) {
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
		Long ret = 0L;
		addItemToBasketRepository.addToBasket(
				((User)session.getAttribute("user")).getId(),
				item.getItemid(),
				new Long(addToBasketDto.getQuantity()),
				ret
				);
		
//		model.addAttribute("item", item);
//		model.addAttribute(new AddToBasketDto());
		return "product/product";
	}
	
	@RequestMapping("/basket")
	public String basket(Model model) {
		
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
	
	@RequestMapping("/search-result")
	public String searchResult() {
		
		return "search/search-result";
		
	}
	
	
	@RequestMapping("/logout")
	public String logout() {
		
		return "about/about-us";
	}
	
	@RequestMapping("/search-more")
	public String searchMore() {
		
		return "search/search-more";
	}

	@RequestMapping("/credits")
	public String creditsHandler() {
		
		return "profil/credits";
	}
	
	@RequestMapping("/orders")
	public String ordersHandler() {
		
		return "basket/orders";
	}
	
	@RequestMapping("/contact")
	public String contactHandler() {
		
		return "contact";
	}
	
	
	/* Admin route-ok*/
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
