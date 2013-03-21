package com.duckranger.goodproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duckranger.goodproject.domain.OrderItem;
import com.duckranger.goodproject.repository.OrderItemRepository;

@Service
public class OrderItemService {
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Iterable<OrderItem> findAll() {
	return orderItemRepository.findAll();
    }

    public  OrderItem save( OrderItem t) {
	return orderItemRepository.save(t);
    }

    public void delete(Long id) {
    	orderItemRepository.delete(id);
    }

    public  OrderItem findOne(Long id) {
	return orderItemRepository.findOne(id);
    }
}
