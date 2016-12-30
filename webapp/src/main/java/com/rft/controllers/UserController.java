package com.rft.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.FetchProfile.Item;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.orm.hibernate3.AbstractSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.test.util.MetaAnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rft.dto.AddToBasketDto;
import com.rft.dto.SearchMoreDto;
import com.rft.dto.UserUpdateDto;
import com.rft.entities.Category;
import com.rft.entities.Manufacturer;
import com.rft.entities.OrderView;
import com.rft.entities.Stock;
import com.rft.entities.User;
import com.rft.repositories.AddItemToBasketRepository;
import com.rft.repositories.CategoryRepository;
import com.rft.repositories.ManufacturerRepository;
import com.rft.repositories.OrderViewRepository;
import com.rft.repositories.SearchInStockRepository;
import com.rft.repositories.StockRepository;
import com.rft.repositories.UserRepository;
import com.rft.services.UserService;
import com.rft.util.Util;
import com.rft.validators.RegformDtoValidator;

@Controller
public class UserController {
	
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
	@Autowired
	private OrderViewRepository orderViewRepository;
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SearchInStockRepository searchInStockRepository;
	@Autowired
	private EntityManager em;
//	@Autowired
//	private Session session;
	
	
//	@Bean
//	public AbstractSessionFactoryBean sessionFactoryBean(){
//	    AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
//	    sessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
//	    return sessionFactoryBean;
//	}
	
	@RequestMapping(value="/home/{category}/{pageNumber}", method = GET)
	public String home(@PathVariable String category, @PathVariable Integer pageNumber, 
			Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		Page<Stock> items = null;
		if(category.equals("all")) {
			items = stockRepository.findAll(new PageRequest(pageNumber, 3));
		} else {
			items = stockRepository.findByCategoryname(new PageRequest(pageNumber, 3), category);
		}
    	int current = items.getNumber() + 1;
        int begin = Math.max(0, current - 5);
        int end = Math.min(begin + 10, items.getTotalPages()-1);
        
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
    	model.addAttribute("itemsContent", items.getContent());
    	model.addAttribute("items", items);
    	model.addAttribute("category", category);
		
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
		User user = (User) session.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
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
		User user = (User) session.getAttribute("user"); 
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		Stock item = stockRepository.findByItemid(productId);
//		Long ret = -1000L;
		
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("addToBasket");
		query.setParameter("userid", user.getId());
		query.setParameter("itemid", item.getItemid());
		query.setParameter("quantity", new Long(addToBasketDto.getQuantity()));
		query.execute();
		Long ret = (Long) query.getOutputParameterValue("ret");
		
//		addItemToBasketRepository.addToBasket(
//				user.getId(),
//				item.getItemid(),
//				new Long(addToBasketDto.getQuantity()),
//				ret
//				);	
		
		logger.info("addToBasket return value: " + String.valueOf(ret));

		
//		model.addAttribute("item", item);
//		model.addAttribute(new AddToBasketDto());
		return "product/product";
	}
	
	@RequestMapping(value="/basket", method=GET)
	public String basket(Model model, RedirectAttributes redirectAttributes, HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		
		List<OrderView> items = orderViewRepository.findByUseridAndOrderstatusid(new Long(user.getId()), new Long(1));
    	model.addAttribute("itemsContent", items);
    	Long sum = 0L;
    	for(OrderView ov : items) {
    		sum += ov.getPrice();
    	}
    	model.addAttribute("sum", sum);
    	model.addAttribute("count", items.size());
		return "basket/basket";
	}
	
	@RequestMapping(value="/profil", method=GET)
	public String profil(Model model, HttpSession httpSession, RedirectAttributes redirectAttributes) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
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
		User user = (User)httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		long loggedInUserId = user.getId();
		userUpdateDto.setId(loggedInUserId);
		
		String newPassword      = userUpdateDto.getPassword();
		String newPasswordAgain = userUpdateDto.getPassword();
		if( ! newPassword.equals(newPasswordAgain)) {
			model.addAttribute("passwordError", "A megadott jelszavak nem egyeznek.");
			return "profil/profil";
		} 
		
		if(userUpdateDto.getActualPassword().equals(user.getPassword()) && ! "".equals(userUpdateDto.getActualPassword())) {
			userUpdateDto.setPassword(newPassword);
		} else {
			Util.flash(redirectAttributes, "danger", "Az adatmódosítás sikertelen. Hibás aktuális jelszó.");
			return "redirect:/profil";
		}
		
		userUpdateDto.setRole(user.getRole());
		userService.updateUser(userUpdateDto);
		Util.flash(redirectAttributes, "success", "Sikeres adatmódosítás.");
		httpSession.setAttribute("user", Util.userUpdateDtoToEntity(userUpdateDto));
		model.addAttribute("userUpdateDto", userUpdateDto);
//		return "profil/profil";
		return "redirect:/profil";
	}
	
	@RequestMapping(value="/search-more/{pageNumber}", method=GET)
	public String searchMore(Model model, @ModelAttribute String valami, RedirectAttributes redirectAttributes,
			@ModelAttribute("manufacturers") HashMap<String, String> manufacturers,
			@ModelAttribute("categories") HashMap<String, String> categories,
			@PathVariable("pageNumber") Integer pageNumber) {
		logger.info(valami);
		model.addAttribute("searchMoreDto", new SearchMoreDto());
		
		List<Category> listCategoryname = categoryRepository.findAll();
//		Map<String, String> manufacturers = new HashMap<String, String>();
		manufacturers = new HashMap<String, String>();
		manufacturers.put("", "Kérem válasszon a listából");
		for(Category c :listCategoryname) {
			manufacturers.put(String.valueOf(c.getCategoryid()), c.getCategoryname());
		}

		List<Manufacturer> listManufacturers = manufacturerRepository.findAll();
//		Map<String, String> categories = new HashMap<String, String>();
		categories = new HashMap<String, String>();
		categories.put("", "Kérem válasszon a listából");
		for(Manufacturer m : listManufacturers) {
			categories.put(String.valueOf(m.getManufacturerid()), m.getManufacturername());
		}
		
		model.addAttribute("manufacturers", manufacturers);
		model.addAttribute("categories", categories);
		
		return "search/search-more";
	}
	
	@RequestMapping(value="/search-more/{pageNumber}", method=POST)
	public String searchMore(Model model, 
			@ModelAttribute("searchMoreDto") SearchMoreDto searchMoreDto,
			@ModelAttribute("manufacturers") HashMap<String, String> manufacturers,
			@ModelAttribute("categories") HashMap<String, String> categories,
			@PathVariable("pageNumber") Integer pageNumber) {
//		model.addAttribute("valami", "valami");
		
		final Integer priceMin = searchMoreDto.getPriceMin() != null       ? searchMoreDto.getPriceMin() : -1;
		final Integer priceMax = searchMoreDto.getPriceMax() != null       ? searchMoreDto.getPriceMax() : -1;
		final Integer catId    = searchMoreDto.getCategoryId() != null     ? (int)(double)(long) Long.decode(String.valueOf(searchMoreDto.getCategoryId()))         : -1;  // ZSÍRKIRÁJ
		final Integer manId    = searchMoreDto.getManufacturerId() != null ? (int)(long)searchMoreDto.getManufacturerId()     : -1;

//		List<Object> items = searchInStockRepository.SearchItemsInStock(
//				searchMoreDto.getName(),
//				manId, catId, priceMin, priceMax);
//		
		List<Stock> items = stockRepository.find(
				searchMoreDto.getName(), manId, catId, priceMin, priceMax);
		
		
//		int current = items.getNumber() + 1;
//        int begin = Math.max(0, current - 5);
//        int end = Math.min(begin + 10, items.getTotalPages()-1);
//        
//        model.addAttribute("beginIndex", begin);
//        model.addAttribute("endIndex", end);
//        model.addAttribute("currentIndex", current);
//    	model.addAttribute("itemsContent", items.getContent());
    	model.addAttribute("itemsContent", items);
//    	model.addAttribute("items", items);
    	List<Category> listCategoryname = categoryRepository.findAll();
//		Map<String, String> manufacturers = new HashMap<String, String>();
		manufacturers = new HashMap<String, String>();
		manufacturers.put("", "Kérem válasszon a listából");
		for(Category c :listCategoryname) {
			manufacturers.put(String.valueOf(c.getCategoryid()), c.getCategoryname());
		}

		List<Manufacturer> listManufacturers = manufacturerRepository.findAll();
//		Map<String, String> categories = new HashMap<String, String>();
		categories = new HashMap<String, String>();
		categories.put("", "Kérem válasszon a listából");
		for(Manufacturer m : listManufacturers) {
			categories.put(String.valueOf(m.getManufacturerid()), m.getManufacturername());
		}
		
		model.addAttribute("manufacturers", manufacturers);
		model.addAttribute("categories", categories);
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
