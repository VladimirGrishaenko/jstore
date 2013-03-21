package com.duckranger.goodproject.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.duckranger.goodproject.domain.Product;
import com.duckranger.goodproject.service.ProductService;
import com.duckranger.goodproject.service.ProductTypeService;

@Controller

public class EditProductController {
	private static final Logger logger = LoggerFactory
			.getLogger(EditProductController.class);

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductTypeService productTypeService;

	@RequestMapping(value = "/editproduct", method = RequestMethod.GET)
	public String list(Model model) {
		logger.info("Listing Walks");
		model.addAttribute("types", productTypeService.findAll());
		model.addAttribute("products", productService.findAll());
	
	
		return "products/Editproduct";
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String listDel(Model model) {
		logger.info("Listing Walks");
		model.addAttribute("types", productTypeService.findAll());
		model.addAttribute("products", productService.findAll());
	
	
		return "products/deleteProduct";
	}
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String listAdd(Model model) {
		logger.info("Listing Walks");
		model.addAttribute("types", productTypeService.findAll());
		model.addAttribute("products", productService.findAll());
	
	
		return "products/addProduct";
	}
	
	

	 @RequestMapping(value = "/param", method = RequestMethod.GET)
	    public String requestParam(@RequestParam("id") long arg1, Model model) {
			model.addAttribute("types", productTypeService.findAll());
			model.addAttribute("product", 
	                                productService.findOne(arg1));
			
	        return "products/OneProductInfo";
	    }
	 
	 
	 
	 		
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public  void ModelAndView(Model model, HttpServletRequest request) {

		logger.info("Listing Walks");
		model.addAttribute("lastId",	productService.addProduct(request.getParameter("name"),
						(Double.parseDouble(request.getParameter("price"))),
						(Integer.parseInt(request.getParameter("quantity"))),
						request.getParameter("descr"), request.getParameter("type"),
						"resources/images/186567676.gif"));
		

		
	}

	@RequestMapping(value = "Delete", method = RequestMethod.POST)
	public String ModelAndView1(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

		logger.info("Listing Walks");
		try{
		productService.deleteProductByName(request.getParameter("name"));
  	}
  	catch(Exception e){
  		System.out.println(e.toString());
  		
	  
	  
  }
		return "redirect:/deleteProduct";
	}
	
	@RequestMapping(value = "Search", method = RequestMethod.POST)
	public String ModelAndView2(Model model, HttpServletRequest request) throws UnsupportedEncodingException {

		logger.info("Listing Walks");
		model.addAttribute("productTypes", productTypeService.findAll());
		model.addAttribute("link", "n=price&s=asc");
		model.addAttribute("products", productService.searchProduct(request.getParameter("nameProduct")));		
	return "products/Search";
	}
	
	@RequestMapping(value = "/edit")
	@ResponseBody
	public  void Edit (Model model, HttpServletRequest request) {

		logger.info("Listing Walks");
		productService.EditProduct((Integer.parseInt(request.getParameter("id"))),request.getParameter("name"),
				(Double.parseDouble(request.getParameter("price"))),
				(Integer.parseInt(request.getParameter("quantity"))),
				request.getParameter("descr"), request.getParameter("type"),
				"resources/images/item_new.gif");

	
	}
	
	@RequestMapping(value = "/EditPicture", method = RequestMethod.GET)
	public String listOnePicture(@RequestParam("pId") long arg1, Model model) {
		logger.info("Listing Walks");				
		model.addAttribute("product", productService.findOne(arg1));	
		return "products/OnePicture";
	}
	
	@RequestMapping(value = "/editpicture", method = RequestMethod.GET)
	public String listPicture(Model model) {
		logger.info("Listing Walks");		
		model.addAttribute("products", productService.findAll());	
		return "products/EditPicture";
	}
	
	
	 @RequestMapping(value = "form", method = RequestMethod.POST)
	    public String processForm(@RequestParam MultipartFile file, Model model,HttpServletRequest request,
	            HttpSession session) {
	    	productService.UploadFile(file,request,session,Integer.parseInt(request.getParameter("idpicture")));      
	    	return "redirect:/editproduct";
	    }
	
	 
	 

	@RequestMapping(value = "DeleteFew", method = RequestMethod.POST)
	public String DeleteFew(Model model, HttpServletRequest request) {

		logger.info("Listing Walks");
		String[] ids = productService.getAllId().split(",");
		for (String a : ids) {
			try {
				String s = request.getParameter(a);
				if (!s.isEmpty()) {
				productService.delete(new Long(Integer.parseInt(s)));
				}
			} catch (Exception e) {

			}

		}

		productService.deleteProductByName(request.getParameter("name"));

		return "redirect:/deleteProduct";
	}

//	@RequestMapping(value = "AddFromFile", method = RequestMethod.POST)
//	public String addFromFile(Model model, HttpServletRequest request) throws ServletException, IOException {
//
//		logger.info("Listing Walks");
//		productService.AddFromFile(request);
//
//		return "redirect:/editproduct";
//	}

}
