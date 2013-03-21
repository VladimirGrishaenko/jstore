package com.duckranger.goodproject.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duckranger.goodproject.service.OrderService;
import com.duckranger.goodproject.service.ProductTypeService;

@Controller
public class StatusController {
	private static final Logger logger = LoggerFactory
			.getLogger(StatusController.class);

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductTypeService productTypeService;

	@RequestMapping(value = "/Status", method = RequestMethod.GET)
	public String listOrder(Model model, HttpServletRequest request) {
		logger.info("Listing Walks");
		model.addAttribute("link", "n=productName&s=asc");
		if(request.getQueryString()!=null){
		try {
			model.addAttribute(
					"order",
					"Статус заказа номер: "
							+ request.getParameter("id")
							+ " в данный момент: "
							+ orderService.findOne(
									new Long(request.getParameter("id")))
									.getOrderStatus());
		} catch (Exception e) {
			System.out.println(e.toString());
			model.addAttribute("order","Заказ с таким номером отсуствует");

		}}
		model.addAttribute("productTypes", productTypeService.findAll());
		return "Status";
	}

}
