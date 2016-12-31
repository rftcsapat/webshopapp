package com.rft.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import static com.rft.util.Constants.PACK_STANDARD_FT;
import static com.rft.util.Constants.PACK_STANDARD_KR;
import static com.rft.util.Constants.PACK_ELITE_FT;
import static com.rft.util.Constants.PACK_ELITE_KR;
import static com.rft.util.Constants.PACK_PREMIUM_FT;
import static com.rft.util.Constants.PACK_PREMIUM_KR;

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
import com.rft.dto.CreditDto;
import com.rft.dto.SearchDto;
import com.rft.dto.SearchMoreDto;
import com.rft.dto.UserUpdateDto;
import com.rft.entities.Category;
import com.rft.entities.Manufacturer;
import com.rft.entities.OrderView;
import com.rft.entities.Stock;
import com.rft.entities.User;
import com.rft.entities.Warehouse;
import com.rft.repositories.AddItemToBasketRepository;
import com.rft.repositories.CategoryRepository;
import com.rft.repositories.CoinUploadRepository;
import com.rft.repositories.ManufacturerRepository;
import com.rft.repositories.OrderViewRepository;
import com.rft.repositories.PaymentRepository;
import com.rft.repositories.SearchInStockRepository;
import com.rft.repositories.StockRepository;
import com.rft.repositories.UserRepository;
import com.rft.repositories.WarehouseRepository;
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
	private CoinUploadRepository coinUploadRepository;
	@Autowired
	private PaymentRepository paymentRepository ;
	@Autowired
	private EntityManager em;
	
	
	@RequestMapping(value="/home/{category}/{pageNumber}", method = GET)
	public String home(@PathVariable String category, @PathVariable Integer pageNumber, 
			Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", new SearchDto());
		Page<Stock> items = null;
		Integer pageSize = 9;
		if(category.equals("all")) {
			items = stockRepository.findAll(new PageRequest(pageNumber, pageSize));
		} else {
			items = stockRepository.findByCategoryname(new PageRequest(pageNumber, pageSize), category);
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
	
	@RequestMapping(value="/home/{category}/{pageNumber}", method = POST)
	public String home(@ModelAttribute("searchDto") SearchDto searchDto, Model model, RedirectAttributes redirectAttributes, HttpSession session) {
		model.addAttribute("searchDto", searchDto);
		model.addAttribute("keyword", searchDto.getKeyword());
		List<Stock> items = stockRepository.find(searchDto.getKeyword());
		model.addAttribute("resultCount", items.size());
		model.addAttribute("itemsContent", items);
		return "search/search-result";
	}
	
	@RequestMapping(value="/search/", method = GET)
	public String search(
//			@PathVariable String keyword, 
			@ModelAttribute("searchDto") SearchDto searchDto,
			Model model, 
			RedirectAttributes redirectAttributes, 
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", searchDto.getKeyword());
		model.addAttribute("keyword", searchDto);
		List<Stock> items = stockRepository.find(searchDto.getKeyword());
		model.addAttribute("resultCount", searchDto);
//    	int current = items.getNumber() + 1;
//      int begin = Math.max(0, current - 5);
//      int end = Math.min(begin + 10, items.getTotalPages()-1);
//      
//      model.addAttribute("beginIndex", begin);
//      model.addAttribute("endIndex", end);
//      model.addAttribute("currentIndex", current);
    	model.addAttribute("itemsContent", items);
    	
//    	model.addAttribute("items", items);
//    	model.addAttribute("category", category);
		
		return "search/search-result";
	}
	
	@RequestMapping(value="/deleteBasketEntry/{itemId}/{quantity}", method = GET)
	public String search(
			@PathVariable("itemId") Long itemId,
			@PathVariable("quantity") Long quantity,
			Model model, 
			@ModelAttribute("searchDto") SearchDto searchDto,
			RedirectAttributes redirectAttributes, 
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", searchDto);
		Stock item = stockRepository.findByItemid(itemId);
		
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("addToBasket");
		query.setParameter("userid", user.getId());
		query.setParameter("itemid", item.getItemid());
		query.setParameter("quantity", quantity * (-1));
		query.execute();
//		Long ret = (Long) query.getOutputParameterValue("ret");
		
		
		
//    	model.addAttribute("items", items);
//    	model.addAttribute("category", category);
		
		return "redirect:/basket";
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
		model.addAttribute("searchDto", new SearchDto());
		Stock item = stockRepository.findByItemid(productId);
		model.addAttribute("item", item);
		model.addAttribute("addToBasketDto", new AddToBasketDto());
		
		return "product/product";
	}
	
	@RequestMapping(value="/product/{productId}", method=POST)
	public String product(Model model, HttpSession session, @PathVariable("productId") Long productId, 
			@ModelAttribute("addToBasketDto") @Valid AddToBasketDto addToBasketDto,
			BindingResult result,
//			@ModelAttribute("productId") Integer productId,
//			@ModelAttribute("addToBasketDto") AddToBasketDto addToBasketDto,
//			@ModelAttribute("creditDto") CreditDto creditDto,
			RedirectAttributes redirectAttributes ) {
		model.addAttribute("searchDto", new SearchDto());
//		model.addAttribute("creditDto", creditDto);
		User user = (User) session.getAttribute("user"); 
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		Stock item = stockRepository.findByItemid(productId);
		Long quantity = new Long(addToBasketDto.getQuantity());
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("addToBasket");
		query.setParameter("userid", user.getId());
		query.setParameter("itemid", item.getItemid());
		query.setParameter("quantity", quantity);
		query.execute();
		Long ret = (Long) query.getOutputParameterValue("ret");
		
		if(ret == 0L) {
			model.addAttribute("message", "Sikeresen hozzáadta a kosarához.");
			String newQuantity = String.valueOf(Integer.decode(item.getQuantity()) - quantity);
			item.setQuantity(newQuantity);
		} else if(ret == -1L) {
			model.addAttribute("errorMessage", "A hozzáadás sikertelen.");
		}
//		addItemToBasketRepository.addToBasket(
//				user.getId(),
//				item.getItemid(),
//				new Long(addToBasketDto.getQuantity()),
//				ret
//				);	
		
		logger.info("addToBasket return value: " + String.valueOf(ret));

		
		model.addAttribute("item", item);
//		model.addAttribute(new AddToBasketDto());
		return "product/product";
	}
	
	@RequestMapping(value="/basket", method=GET)
	public String basket(Model model, 
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", new SearchDto());
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
		model.addAttribute("searchDto", new SearchDto());
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
	public String profil(Model model, @ModelAttribute("userUpdateDto") @Valid UserUpdateDto userUpdateDto, 
			 HttpSession httpSession, RedirectAttributes redirectAttributes) {
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
			@PathVariable("pageNumber") Integer pageNumber,
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", new SearchDto());
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
			RedirectAttributes redirectAttributes,
			@PathVariable("pageNumber") Integer pageNumber, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
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

	@RequestMapping(value="/credits", method=GET)
	public String creditsHandler(Model model, RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", new SearchDto());
		model.addAttribute("creditDto", new CreditDto());
		return "profil/credits";
	}
	
	@RequestMapping(value="/credits", method=POST)
	public String creditsHandler(Model model,
			@ModelAttribute("searchMoreDto") SearchMoreDto searchMoreDto,
			@ModelAttribute("creditDto") CreditDto creditDto,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		
		String cardNumber     = creditDto.getCardNumber();
		String cardExpiration = creditDto.getCardExpiration();
		String cardCvc        = creditDto.getCardCvc();
		String packageName    = creditDto.getPackageName();
		
		Long amountKr = 0L;
		Long amountFt = 0L;
		
		switch(packageName) {
			case "standard":
				amountKr = PACK_STANDARD_KR;
				amountFt = PACK_STANDARD_FT;	
				break;
			case "premium":
				amountKr = PACK_PREMIUM_KR;
				amountFt = PACK_PREMIUM_FT;
				break;
			case "elite":
				amountKr = PACK_ELITE_KR;
				amountFt = PACK_ELITE_FT;
				break;
		}
	
		coinUploadRepository.coinUpload(user.getId(), amountFt, amountKr);
		
//		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("addToBasket");
////		query.setParameter("userid", user.getId());
////		query.setParameter("itemid", item.getItemid());
////		query.setParameter("quantity", new Long(addToBasketDto.getQuantity()));
//		query.execute();
//		Long ret = (Long) query.getOutputParameterValue("ret");
		
		return "profil/credits";
	}

	@RequestMapping(value="/product-category", method=GET)
	public String productCategory(Model model, RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", new SearchDto());
		return "product/product-category";
	}
	
	@RequestMapping(value="/search-result", method=GET)
	public String searchResult(Model model, RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", new SearchDto());
		return "search/search-result";
	}
	
//	@RequestMapping(value="/logout", method=GET)
//	public String logout(Model model) {
//		model.addAttribute("searchDto", new SearchDto());
//		return "about/about-us";
//	}
	
	@RequestMapping(value="/orders", method=GET)
	public String ordersHandler(Model model, 
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", new SearchDto());
		
		List<OrderView> items = orderViewRepository.findByUseridAndOrderstatusid(new Long(user.getId()), new Long(1));
    	model.addAttribute("itemsContent", items);
    	Long sum = 0L;
    	for(OrderView ov : items) {
    		sum += ov.getPrice();
    	}
    	model.addAttribute("sum", sum);
    	model.addAttribute("count", items.size());
		
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
		return "basket/orders";
	}
	
	@RequestMapping(value="/orders", method=POST)
	public String ordersHandler(Model model, 
			@ModelAttribute("userUpdateDto") UserUpdateDto userUpdateDto,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "0".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be.");
			return "redirect:/";
		}
		model.addAttribute("searchDto", new SearchDto());
		
//		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("Payment");
//		query.setParameter("userid", user.getId());
//		query.execute();
		
		paymentRepository.Payment(user.getId());	
		
		Util.flash(redirectAttributes, "success", "Köszönjük a vásárlást!");
//		model.addAttribute("message", );
		
		return "redirect:/home/all/0";
	}
	
	
	
}
