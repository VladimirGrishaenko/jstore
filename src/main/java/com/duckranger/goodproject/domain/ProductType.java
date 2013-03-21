package com.duckranger.goodproject.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@Table(name="Product_Type")
public class ProductType extends AbstractPersistable<Long> { 

	private static final long serialVersionUID = 1L;
	private String productType=null;
	
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}
