package com.duckranger.goodproject.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="User_Order")
public class UserOrder extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	
//	@ManyToMany
//	@JoinTable(name="ORDER_PRODUCT")
//	private Set<Product> product;
	
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="OrderItem_ID")
	private Set<OrderItem> orderItem;
		
	
	@ManyToOne(optional=false) 
    @JoinColumn(name="user_fk")
	private User user;
	
	@Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(Set<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
//	public Set<Product> getProduct() {
//		return product;
//	}
//	public void setProduct(Set<Product> product) {
//		this.product = product;
//	}

}
	

