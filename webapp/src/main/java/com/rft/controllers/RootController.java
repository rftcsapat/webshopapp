package com.rft.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.rft.dto.LoginDto;
import com.rft.dto.RegformDto;
import com.rft.dto.SearchDto;
import com.rft.entities.Stock;
import com.rft.entities.User;
import com.rft.repositories.StockRepository;
import com.rft.repositories.UserRepository;
import com.rft.services.UserService;
import com.rft.util.Util;

@Controller
public class RootController {
	
	Logger logger = Logger.getLogger(RootController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Value("${base.url}")
	private String baseUrl;
	
//	@InitBinder("regformDtoValidator")
//	protected void initRegformDtoValidator(WebDataBinder binder) {
//		binder.setValidator(regformDtoValidator);
//	}
	
//	@RequestMapping(value = "/register", method = GET)
//	public String register(Model model) {
//		RegformDto regdto = new RegformDto();
////		model.addAttribute("name", "EgyNév");
//		model.addAttribute("regformDto", regdto);
//		return "register";
//	}
//	
//	@RequestMapping(value = "/register", method = POST)
//	public String register(@ModelAttribute("regformDto") @Valid RegformDto regformDto, BindingResult result, 
//			RedirectAttributes redirectAttributes, Model model) {
//		
//		if(regformDto == null) { 
//			return "redirect:/"; 
//		}
//		
//		String password      = regformDto.getPassword();
//		String passwordAgain = regformDto.getPasswordAgain();
//		
//		if(result.hasErrors()) {
//			return "redirect:/";
//		} else if( ! password.equals(passwordAgain)) {
//			model.addAttribute("passwordError", "The given passwords does not match!");
//			return "register";
//		} 
//		
//		User user = userRepository.findByUsername(regformDto.getUsername());
//		if(user != null) {
//			model.addAttribute("usernameError", "Username has already taken.");
//			return "register";
//		}
//		
//		userService.register(regformDto, "0");
//		Util.flash(redirectAttributes, "success", "Signup successful.");
//		logger.info(regformDto.toString());
//		
//		return "redirect:/";
//	}
	
//	@RequestMapping(value = "/login", method = GET)
//	public String login(Model model) {
//		model.addAttribute("loginDto", new LoginDto());
//		return "login";
//	}
//	
//	@RequestMapping(value = "/login", method = POST)
//	public String login(@ModelAttribute("loginDto") @Valid LoginDto loginDto, BindingResult result, Model model, RedirectAttributes redir) {
//		if(result.hasErrors()) {
//			model.addAttribute("loginError", "Something went wrong.");
//			return "login";
//		}
//		
//		User user = userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
//		if(user == null) {
//			model.addAttribute("loginError", "Login failed... cuz'");
//			return "login";
//		} else {
//			if(user.getRole().equals("0")) {
//				UserUpdateDto dto = new UserUpdateDto();
//				dto.setBirthDate(user.getBirthdate());
//				dto.setFirstname(user.getFirstname());
//				dto.setLastname(user.getLastname());
////				dto.setPassword(user.getPassword());
////				dto.setPasswordAgain(user.getPassword());
//				dto.setUsername(user.getUsername());
//				redir.addAttribute("userUpdateDto", dto);
//				model.addAttribute("userUpdateDto", dto);
////				return "redirect:/user";
//				return "user";
//			} else {
//				return "admin";
//			}
//		}
//	}
	
	@RequestMapping("/")
	public String about(Model model, HttpSession session) {
//		model.addAttribute(baseUrl);
		session.setAttribute("baseUrl", baseUrl);
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
					RedirectView rv = new RedirectView();
			        rv.setContextRelative(true);
			        rv.setUrl("/test2/{testPath}/{id}");
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

	
	@RequestMapping(value="/contact", method=GET)
	public String contactHandler(Model model) {
		model.addAttribute("searchDto", new SearchDto());
		return "contact";
	}

	@RequestMapping(value = "/imageDisplay", method = GET)
	  public void showImage(@RequestParam("id") Integer itemId, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
	    Stock item = stockRepository.findByItemid(itemId);
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(item.getPicture());
	    response.getOutputStream().close();
	}

	@RequestMapping(value ="/eeszt", method = GET)
	public String eeszt(Model model, HttpSession httpSession) {
		return "sign/hello2";
	}
	
}
