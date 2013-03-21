package com.duckranger.goodproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duckranger.goodproject.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
