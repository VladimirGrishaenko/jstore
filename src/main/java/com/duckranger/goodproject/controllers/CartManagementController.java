package com.duckranger.goodproject.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duckranger.goodproject.service.ProductService;

@Controller
@Scope("request")
public class CartManagementController {
	@Autowired
	private ShoppingCart cart;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductService productTypeService;

	@RequestMapping(value = "/shopcartadd")
	public String shopCartAdd(HttpServletRequest request, Model model) {
		cart.setOis(Long.parseLong(request.getParameter("prod_id")));
		model.addAttribute("products", cart.getOis());
		model.addAttribute("productTypes", productTypeService.findAll());
		return "redirect:/";

	}

	@RequestMapping(value = "/shopcartinfo")
	public String shopCartInfo(HttpServletRequest request, Model model) {
		model.addAttribute("products", cart.getOis());
		model.addAttribute("productTypes", productTypeService.findAll());
		return "products/ShopCart";
	}

	@RequestMapping(value = "/deleteorderitem")
	public String shopCartDeleteProduct(HttpServletRequest request, Model model) {
		model.addAttribute("productTypes", productTypeService.findAll());
		if (request.getParameter("prod_id") != "") {
			cart.deleteOrderItem(Integer.parseInt(request
					.getParameter("prod_id")));
		}
		return "products/ShopCart";
	}

}