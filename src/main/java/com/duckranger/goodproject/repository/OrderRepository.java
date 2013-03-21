package com.duckranger.goodproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duckranger.goodproject.domain.UserOrder;

public interface OrderRepository extends JpaRepository<UserOrder, Long>{

}
