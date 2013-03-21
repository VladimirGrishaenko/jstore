package com.duckranger.goodproject.controllers;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.duckranger.goodproject.domain.ProductType;
import com.duckranger.goodproject.service.ProductService;
import com.duckranger.goodproject.service.ProductTypeService;

@Controller
public class ProductTypeController  {
	private static final Logger logger = LoggerFactory
			.getLogger(ProductTypeController.class);

	@Autowired
	private ProductTypeService productTypeService;


    @Autowired
    private ProductService productService;
	
	@RequestMapping(value = "/editproducttype", method = RequestMethod.GET)
	public String listAdd(Model model) {
		logger.info("Listing Walks");

		return "ProductTypes/Editproducttype";
	}
	
	
	

	
    @RequestMapping(value = "/infoproducttype", method = RequestMethod.GET)
    public String list(Model model) {
	logger.info("Listing Walks");
	model.addAttribute("productTypes", productTypeService.findAll());
	return "ProductTypes/InfoProductType";
    }

    
	@RequestMapping(value = "AddProductType", method = RequestMethod.POST)
	public String addModelAndView(Model model, HttpServletRequest request) {

		logger.info("Listing Walks");
		String name = request.getParameter("productType");	
		
		ProductType pr = new ProductType();		
		pr.setProductType(name);
		
		productTypeService.save(pr);
         
		return "redirect:/editproducttype";
	}

	@RequestMapping(value = "DeleteProductType", method = RequestMethod.POST)
	public String deleteModelAndView(Model model, HttpServletRequest request) {
		logger.info("Listing Walks");
		 Iterable<ProductType> p = productTypeService.findAll();
		 for(ProductType a : p){
			 if(a.getProductType().equals(request.getParameter("productType"))){
				 productTypeService.delete(a.getId());
				 break;
			 }
		 }
		
		return "redirect:/editproducttype";

	}
}



