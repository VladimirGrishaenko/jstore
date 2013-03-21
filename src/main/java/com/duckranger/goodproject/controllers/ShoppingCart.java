package com.duckranger.goodproject.controllers;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.duckranger.goodproject.domain.OrderItem;
import com.duckranger.goodproject.service.OrderItemService;
import com.duckranger.goodproject.service.ProductService;


@Component
@Scope("session")

public class ShoppingCart {
	
	    @Autowired
	   private ProductService productService;
	  
	  @Autowired
	  OrderItemService orderItemService;

	  
 private Set<OrderItem> ois = new HashSet<OrderItem>();
	   	

	private static int flag=0;
   
	   
	public Set<OrderItem> getOis() {
		return ois;
	}

	public void setOis(Long pi) {
		OrderItem oi = new OrderItem();
		oi.setProduct(productService.findOne(pi));
		System.out.println("New product2:"+oi.getProduct().getProductName());
		
		if(flag>0){
			
			
			if(this.valid(oi)){
				for(OrderItem o: this.ois){
					if(o.getProduct().getId()==oi.getProduct().getId()){
						o.setQuantity(o.getQuantity()+1);
					}
				}
			}
			
			else{
				oi.setQuantity(1);
				this.ois.add(oi);
				System.out.println("New productt:"+oi.getProduct().getProductName());
			}
			
		}
			
		else{
			flag++;
			oi.setQuantity(1);
			this.ois.add(oi);
			System.out.println("New product:"+oi.getProduct().getProductName());
		}
		
		for(OrderItem o: this.ois){
			System.out.println(o.getProduct().getProductName()+o.getProduct().getId());
//			orderItemService.save(o);
//			ois.add(o);
		}
		
		
	}
	
	
	public void deleteOrderItem(int id){
		System.out.println("ProductDel");
		for(OrderItem o: this.ois){
			if(o.getProduct().getId()==id){
				this.ois.remove(o);
			}
		}	
	}
	
	public void updateQuantity(int q,int id){
		for(OrderItem o: this.ois){
			if(o.getProduct().getId()==id){
				o.setQuantity(q);
			}
		}	
	}
	
	public boolean valid(OrderItem oi){

		boolean flag=false;
		
		for(OrderItem o: this.ois){
			if(o.getProduct().getId()==oi.getProduct().getId()){
				flag=true;
				break;
		}
			else flag=false;	
		}
		return flag;
	}
}
