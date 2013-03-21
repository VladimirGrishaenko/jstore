package com.duckranger.goodproject.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duckranger.goodproject.domain.OrderItem;
import com.duckranger.goodproject.domain.OrderStatus;
import com.duckranger.goodproject.domain.Role;
import com.duckranger.goodproject.domain.User;
import com.duckranger.goodproject.domain.UserOrder;
import com.duckranger.goodproject.service.OrderItemService;
import com.duckranger.goodproject.service.OrderService;
import com.duckranger.goodproject.service.ProductService;
import com.duckranger.goodproject.service.ProductTypeService;
import com.duckranger.goodproject.service.UserService;

@Controller
@Scope("request")

public class CompliteOrder {
	
	   @Autowired
		private UserService userService;
	   
	   
	   @Autowired
		private ProductTypeService productTypeService;
	   
	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;
	@Autowired
	   private ShoppingCart cart;
	
	 
	  @Autowired
	  OrderItemService orderItemService;
	  
	 @RequestMapping(value = "/compliteorder")
	   public String requestParamComplited(HttpServletRequest request, Model model) {
		 
		 model.addAttribute("types", productTypeService.findAll());
		
			
		 	String quantity=request.getParameter("quant");
		 	String[] qp = quantity.split(",");
		 	
		 	for(int i=0;i<qp.length;i++){
		 		String[] q=qp[i].split("-");
		 		System.out.println("qp="+qp[i]);
		 		for(int j=0;j<q.length-1;j++){
		 			System.out.println("q="+q[j]+" "+q[j+1]);
		 			cart.updateQuantity(Integer.parseInt(q[j]),Integer.parseInt(q[j+1]));
		 		}
		 	}
		 	
		 
			User u = new User();
			u.setEmail(request.getParameter("email"));
			u.setFirstName(request.getParameter("name"));
			u.setPhone(request.getParameter("phone"));
			u.setRole(Role.ROLE_LOGUSER);
			userService.save(u);
	
			 
			
			for(OrderItem o: cart.getOis()){
				orderItemService.save(o);		
			}
			
			
			UserOrder or = new UserOrder();
			or.setOrderItem(cart.getOis());
			or.setUser(u);
			or.setOrderStatus(OrderStatus.PROCESSED);
			orderService.save(or);	 
			model.addAttribute("id", or.getId());
		
			HttpSession session = request.getSession();
			 session.invalidate();
			 model.addAttribute("productTypes", productTypeService.findAll());
			 
			
	   	return "products/CompliteOrder";
	   }  
}
