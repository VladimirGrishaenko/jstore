package com.duckranger.goodproject.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duckranger.goodproject.domain.User;
import com.duckranger.goodproject.service.ProductTypeService;
import com.duckranger.goodproject.service.UserService;

@Controller
public class UserController { 
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ProductTypeService productTypeService;
	
	@RequestMapping(value = "/edituser{pageNumber}", method = RequestMethod.GET)
	public String listAdd(@PathVariable Integer pageNumber, Model model,
   			HttpServletRequest request) {		
		logger.info("Listing Walks");	
		Page<User> page= userService.findAllU(pageNumber);
   		int current = page.getNumber() + 1;
   		int begin = Math.max(1, current - 5);
   		int end = Math.min(begin + 10, page.getTotalPages());
   		model.addAttribute("page", page);

   		model.addAttribute("list", page.getContent());
   		model.addAttribute("beginIndex", begin);
   		model.addAttribute("endIndex", end);
   		model.addAttribute("currentIndex", current);
		
		return "users/EditUser";
	}
	
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String listUser(Model model) {
    logger.info("Listing Walks");	
   
	return "users/AddUser";
    }
    
    @RequestMapping(value = "/infouser{pageNumber}", method = RequestMethod.GET)
   	public String getRunbookPage(@PathVariable Integer pageNumber, Model model,
   			HttpServletRequest request) {
       	Page<User> page= userService.findAllU(pageNumber);
   		int current = page.getNumber() + 1;
   		int begin = Math.max(1, current - 5);
   		int end = Math.min(begin + 10, page.getTotalPages());
   		model.addAttribute("page", page);

   		model.addAttribute("list", page.getContent());
   		model.addAttribute("beginIndex", begin);
   		model.addAttribute("endIndex", end);
   		model.addAttribute("currentIndex", current);
   				
   	return "users/InfoUser";
   	 }

   
	@RequestMapping(value = "/addoneuser")
	@ResponseBody
	public void addModelAndView(Model model, HttpServletRequest request) {
		logger.info("Listing Walks");		
		userService.addUser(request.getParameter("name"), request.getParameter("phone"), 
											request.getParameter("email"), request.getParameter("role"),request.getParameter("username"));
     }

	@RequestMapping(value = "DeleteUser", method = RequestMethod.POST)
	public String deleteModelAndView(Model model, HttpServletRequest request) {
		logger.info("Listing Walks");
		
		 userService.deleteUserByName(request.getParameter("name"));
		return "redirect:/edituser1";

	}
	
	@RequestMapping(value = "DeleteFewUsers", method = RequestMethod.POST)
	public String DeleteFew(Model model, HttpServletRequest request) {

				
		logger.info("Listing Walks");
		Iterable<User> pr = userService.findAll();
		for (User a : pr) {
			try {
				String s = request.getParameter(a.getId().toString());
				if (!s.isEmpty()) {
					userService.deleteUserByName(a.getFirstName());
				}
			} catch (Exception e) {

			}

		}

		userService.deleteUserByName(request.getParameter("name"));

		return "redirect:/edituser1";
	}
	
	@RequestMapping(value = "/editoneuser")
	@ResponseBody
	public  void Edit (Model model, HttpServletRequest request) {

		logger.info("Listing Walks");
		userService.editUser((Integer.parseInt(request.getParameter("id"))),request.getParameter("name"),
				request.getParameter("phone"),				
				request.getParameter("email"), request.getParameter("username"),request.getParameter("role"));
	}
	
	
	@RequestMapping(value = "/editfewuser{pageNumber}", method = RequestMethod.GET)
	public String listDel(@PathVariable Integer pageNumber, Model model,
   			HttpServletRequest request) {
		logger.info("Listing Walks");
		
	  	Page<User> page= userService.findAllU(pageNumber);
   		int current = page.getNumber() + 1;
   		int begin = Math.max(1, current - 5);
   		int end = Math.min(begin + 10, page.getTotalPages());
   		model.addAttribute("page", page);
   		model.addAttribute("list", page.getContent());
   		model.addAttribute("beginIndex", begin);
   		model.addAttribute("endIndex", end);
   		model.addAttribute("currentIndex", current);	
		return "users/EditOneUser";
	}
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String listContact(Model model) {
		logger.info("Listing Walks");	
		model.addAttribute("types", productTypeService.findAll());
	return "users/Contacts";
    }
	
	
	
}
