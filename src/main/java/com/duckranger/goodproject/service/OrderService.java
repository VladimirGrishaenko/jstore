package com.duckranger.goodproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duckranger.goodproject.domain.OrderStatus;
import com.duckranger.goodproject.domain.UserOrder;
import com.duckranger.goodproject.repository.OrderRepository;

@Service
public class OrderService {
	 private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	    @Autowired
	    private OrderRepository orderRepository;

	    public Iterable<UserOrder> findAll() {
		return orderRepository.findAll();
	    }

	    public UserOrder save(UserOrder t) {
		return orderRepository.save(t);
	    }

	    public void delete(Long id) {
	    	orderRepository.delete(id);
	    }

	    public UserOrder findOne(Long id) {
		return orderRepository.findOne(id);
	    }
	    
	    public void editOrderStatus(String status, int id){
	    	OrderStatus os = null;
	    	for (OrderStatus stat : OrderStatus.values()){
	    		if (stat.toString().equalsIgnoreCase(status)){
	    			os=stat;
	    			break;
	    		}
	    	}
	    	
	    	UserOrder userOrder = findOne(new Long(id));
	    	userOrder.setOrderStatus(os);
	    	save(userOrder);	
	    }
}
