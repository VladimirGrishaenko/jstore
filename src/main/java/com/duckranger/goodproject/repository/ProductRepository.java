package com.duckranger.goodproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.duckranger.goodproject.domain.Product;
import com.duckranger.goodproject.domain.ProductType;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Page<Product> findByProductType(ProductType productType,  Pageable pageable);
	Page<Product> findByPriceBetween(Double priceLow, Double priceHigh,  Pageable pageable );
	Page<Product> findByProductTypeAndPriceBetween(ProductType productType,Double priceLow, Double priceHigh,  Pageable pageable );

}
