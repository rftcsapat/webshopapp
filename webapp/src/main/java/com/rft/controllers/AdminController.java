package com.rft.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rft.dto.ItemModDto;
import com.rft.dto.ProductSelectDto;
import com.rft.dto.RegformDto;
import com.rft.entities.Category;
import com.rft.entities.Manufacturer;
import com.rft.entities.Stock;
import com.rft.entities.User;
import com.rft.repositories.AddItemToBasketRepository;
import com.rft.repositories.CategoryRepository;
import com.rft.repositories.ItemUploadRepository;
import com.rft.repositories.ManufacturerRepository;
import com.rft.repositories.StockRepository;
import com.rft.repositories.UserRepository;
import com.rft.services.UserService;
import com.rft.util.Util;
import com.rft.validators.RegformDtoValidator;


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
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	@Autowired
	private ItemUploadRepository itemUploadRepository;
	@Autowired
	private EntityManager em;
	

	
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
		model.addAttribute("itemModDto", new ItemModDto());
		List<Category> listCategoryname = categoryRepository.findAll();
		List<Manufacturer> listManufacturers = manufacturerRepository.findAll();

		HashMap<String, String> manufacturers = new HashMap<String, String>();
		HashMap<String, String> categories = new HashMap<String, String>();
		
		categories.put("", "Kérem válasszon a listából");
		for(Category c :listCategoryname) {
			categories.put(String.valueOf(c.getCategoryid()), c.getCategoryname());
		}

		manufacturers.put("", "Kérem válasszon a listából");
		for(Manufacturer m : listManufacturers) {
			manufacturers.put(String.valueOf(m.getManufacturerid()), m.getManufacturername());
		}
		
		model.addAttribute("manufacturers", manufacturers);
		model.addAttribute("categories", categories);
		return "admin/product-add";
	}
	
	@RequestMapping(value="/admin-product-add", method = POST)
	public  String adminProductAdd(Model model,
			@ModelAttribute("itemModDto") ItemModDto mod,
			RedirectAttributes redirectAttributes, 
			HttpSession httpSession,
			@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) throws IOException {
		
		

		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return new String("redirect:/");
		}
		
		byte[] imagein= files[0].getBytes();
		Byte[] imageout = new Byte[imagein.length];
		for (int i=0;i<imagein.length;i++)
			imageout[i]=imagein[i];
	
		model.addAttribute("itemModDto", mod);
		List<Manufacturer> listManufacturers = manufacturerRepository.findAll();
		HashMap<String, String> categories = new HashMap<String, String>();
		List<Category> listCategoryname = categoryRepository.findAll();
		HashMap<String, String> manufacturers = new HashMap<String, String>();
		manufacturers.put("", "Kérem válasszon a listából");
		for(Category c :listCategoryname) {
			categories.put(String.valueOf(c.getCategoryid()), c.getCategoryname());
		}

		
		categories.put("", "Kérem válasszon a listából");
		for(Manufacturer m : listManufacturers) {
			manufacturers.put(String.valueOf(m.getManufacturerid()), m.getManufacturername());
		}
		
		model.addAttribute("manufacturers", manufacturers);
		model.addAttribute("categories", categories);

		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("itemupload");
		query.setParameter("itemid", new Long(-1));
		query.setParameter("itemname", mod.getName());
		query.setParameter("description", mod.getDescription());
		query.setParameter("picture", imageout);
		query.setParameter("price", mod.getPrice());
		query.setParameter("itemquantity", mod.getItemQuantity());
		query.setParameter("unit", mod.getUnit());
		query.setParameter("largedesc", mod.getLargeDesc());
		query.setParameter("manufacturerid", Long.decode(mod.getManufacturerId()));
		query.setParameter("categoryid", Long.decode(mod.getCategoryId()));
		query.setParameter("quantity", mod.getQuantity());
		query.execute();
		Long ret = (Long) query.getOutputParameterValue("ret");
		
		
		if(ret > -1) {
			Util.flash(redirectAttributes, "success", "Sikeres termék hozzáadás!");
		}
		
		return new String("redirect:/admin-product-add");
		
	}
	
	@RequestMapping(value="/admin-product-modified/{itemId}", method = GET)
	public String adminProductModify(Model model,
			@PathVariable("itemId") Long itemId,
			RedirectAttributes redirectAttributes,
			HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return "redirect:/";
		}		   	
		List<Category> listCategoryname = categoryRepository.findAll();
		List<Manufacturer> listManufacturers = manufacturerRepository.findAll();

		HashMap<String, String> manufacturers = new HashMap<String, String>();
		HashMap<String, String> categories = new HashMap<String, String>();
		
		categories.put("", "Kérem válasszon a listából");
		for(Category c :listCategoryname) {
			categories.put(String.valueOf(c.getCategoryid()), c.getCategoryname());
		}

		manufacturers.put("", "Kérem válasszon a listából");
		for(Manufacturer m : listManufacturers) {
			manufacturers.put(String.valueOf(m.getManufacturerid()), m.getManufacturername());
		}
		
		model.addAttribute("manufacturers", manufacturers);
		model.addAttribute("categories", categories);
		
		Stock item = stockRepository.findByItemid(itemId);
		model.addAttribute("item", item);
		ItemModDto mod = new ItemModDto();
		mod.setName(item.getItemname());
		mod.setDescription(item.getDescription());
		mod.setLargeDesc(item.getLargedesc());
		mod.setManufacturerId(item.getManufacturerid());
		mod.setCategoryId(item.getCategoryid());
		mod.setPicture(null);
		mod.setItemQuantity(Long.decode(item.getItemquantity()));
		mod.setUnit(item.getUnit());
		mod.setQuantity(Long.decode(item.getQuantity()));
		mod.setPrice(Long.decode(item.getPrice()));
		
		model.addAttribute("itemModDto", mod);
		return "admin/product-modified";
	}
	
	@RequestMapping(value="/admin-product-modified/{itemId}", method = POST)
	public String adminProductModify(Model model,
			@ModelAttribute("itemModDto") ItemModDto mod,
			@ModelAttribute("item") Stock item,
			@PathVariable("itemId") Long itemId,
			RedirectAttributes redirectAttributes,
			HttpSession httpSession,
			@RequestParam("name") String[] names,
			@RequestParam("file") MultipartFile[] files) throws IOException {
						
		User user = (User) httpSession.getAttribute("user");
		if(user == null || ( ! "1".equals(user.getRole())))  {
			Util.flash(redirectAttributes, "danger", "Kérem, a folytatáshoz jelentkezzen be adminisztrátorként!");
			return new String("redirect:/");
		}
		
		byte[] imagein= files[0].getBytes();
		Byte[] imageout = new Byte[imagein.length];
		for (int i=0;i<imagein.length;i++)
			imageout[i]=imagein[i];
		   
		List<Category> listCategoryname = categoryRepository.findAll();
		HashMap<String, String> manufacturers = new HashMap<String, String>();
		manufacturers.put("", "Kérem válasszon a listából");
		for(Category c :listCategoryname) {
			manufacturers.put(String.valueOf(c.getCategoryid()), c.getCategoryname());
		}

		List<Manufacturer> listManufacturers = manufacturerRepository.findAll();
		HashMap<String, String> categories = new HashMap<String, String>();
		categories.put("", "Kérem válasszon a listából");
		for(Manufacturer m : listManufacturers) {
			categories.put(String.valueOf(m.getManufacturerid()), m.getManufacturername());
		}
		model.addAttribute("manufacturers", manufacturers);
		model.addAttribute("categories", categories);
		
//		Stock item = stockRepository.findByItemid(itemId);
//		ItemModDto mod = new ItemModDto();
//		mod.setName(item.getItemname());
//		mod.setDescription(item.getDescription());
//		mod.setLongDesc(item.getLargedesc());
//		mod.setCategoryId(item.getCategoryid());
//		mod.setManufacturerId(item.getManufacturerid());
		
		model.addAttribute("itemModDto", mod);
		
		StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("itemupload");
		query.setParameter("itemid", itemId);
		query.setParameter("itemname", mod.getName());
		query.setParameter("description", mod.getDescription());
		query.setParameter("picture", imageout);
		query.setParameter("price", mod.getPrice());
		query.setParameter("itemquantity", mod.getItemQuantity());
		query.setParameter("unit", mod.getUnit());
		query.setParameter("largedesc", mod.getLargeDesc());
		query.setParameter("manufacturerid", Long.decode(mod.getManufacturerId()));
		query.setParameter("categoryid", Long.decode(mod.getCategoryId()));
		query.setParameter("quantity", mod.getQuantity());
		query.execute();
		Long ret = (Long) query.getOutputParameterValue("ret");
		
		if(ret > -1) {
			Util.flash(redirectAttributes, "success", "Sikeres termék módosítás!");
		}
		
		return "redirect:/admin-product-modified/"+itemId;
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
		return "redirect:/admin-product-modified/" + String.valueOf(productSelectDto.getItemId());
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
