package com.duckranger.goodproject.controllers;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duckranger.goodproject.service.OrderService;

@Controller
public class ManagerControler {
	private static final Logger logger = LoggerFactory
			.getLogger(ManagerControler.class);
	
	@Autowired
	private OrderService orderService;
		
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String listOrder(Model model) {
		logger.info("Listing Walks");
		model.addAttribute("orders", orderService.findAll());
		return "manager";		
	}
	
	@RequestMapping(value = "/changestatus")
	@ResponseBody
	public void changeStatus (Model model, HttpServletRequest request) {
		orderService.editOrderStatus(request.getParameter("status"), Integer.parseInt(request.getParameter("id")));
	}
}
