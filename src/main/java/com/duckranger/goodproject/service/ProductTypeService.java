package com.duckranger.goodproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duckranger.goodproject.domain.ProductType;
import com.duckranger.goodproject.repository.ProductTypeRepository;

@Service
public class ProductTypeService {
	 private static final Logger logger = LoggerFactory.getLogger(ProductTypeService.class);

	    @Autowired
	    private ProductTypeRepository productTypeRepository;

	    public Iterable<ProductType> findAll() {
		return productTypeRepository.findAll();
	    }

	    public ProductType save(ProductType t) {
		return productTypeRepository.save(t);
	    }

	    public void delete(Long id) {
	    	productTypeRepository.delete(id);
	    }

	    public ProductType findOne(Long id) {
		return productTypeRepository.findOne(id);
	    }
}
