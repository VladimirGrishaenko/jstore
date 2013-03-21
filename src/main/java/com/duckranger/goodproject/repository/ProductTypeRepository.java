package com.duckranger.goodproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duckranger.goodproject.domain.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long>{

}
