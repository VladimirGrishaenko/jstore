package com.duckranger.goodproject.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="order_item")
public class OrderItem extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	
//	@ManyToOne(optional=false) 
//    @JoinColumn(name="ORDER_ID", nullable=false, updatable=false)
//	private UserOrder userOrder=null;
	
	
	@ManyToMany(mappedBy="orderItem")
	private Set<UserOrder> userOrder;
	
	
//	
//	@OneToOne
//    @JoinColumn(
//    name="PRODUCT_ID")
	 @ManyToOne
	    @JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product=null;
	
	
	private Integer quantity=null;
	

//	public UserOrder getUserOrder() {
//		return userOrder;
//	}
//	public void setUserOrder(UserOrder userOrder) {
//		this.userOrder = userOrder;
//	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Set<UserOrder> getUserOrder() {
		return userOrder;
	}
	public void setUserOrder(Set<UserOrder> userOrder) {
		this.userOrder = userOrder;
	}
	

}
