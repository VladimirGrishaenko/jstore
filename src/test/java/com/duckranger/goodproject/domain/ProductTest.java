package com.duckranger.goodproject.domain;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.duckranger.goodproject.Md5;
import com.duckranger.goodproject.service.OrderItemService;
import com.duckranger.goodproject.service.OrderService;
import com.duckranger.goodproject.service.ProductService;
import com.duckranger.goodproject.service.ProductTypeService;
import com.duckranger.goodproject.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:servlet-context.xml", "classpath*:datasource.xml" })
public class ProductTest {

	
	@Autowired
    ProductService productService;
	
	@Autowired
    ProductTypeService productTypeService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;

	
	@Autowired
	OrderItemService orderItemService;

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}

	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	@Test
    public void CreateTest() {
    ApplicationContext ctx = (ApplicationContext)new ClassPathXmlApplicationContext("META-INF/servlet-context.xml");
	
	ProductType pt=new ProductType();
	ProductType pt1=new ProductType();
	ProductType pt2 =new ProductType();
	pt.setProductType("Mobile");
	pt1.setProductType("TV");
	pt2.setProductType("Laptop");
	productTypeService.save(pt);
	productTypeService.save(pt1);
	productTypeService.save(pt2);
    
    Product p = new Product();
	p.setDescription("Cool Mobile");
	p.setImageLink("resources/images/mobile.jpg");
	p.setPrice(3323.99);
	p.setProductName("Nokia");
	p.setQuantity(32);
	p.setProductType(pt);
	productService.save(p);
    
    Product p1 = new Product();
    p1.setDescription("Best TV");
	p1.setImageLink("resources/images/tv.jpg");
	p1.setPrice(7023.32);
	p1.setProductName("Samsung");
	p1.setQuantity(32);
	p1.setProductType(pt);
	productService.save(p1);
	
	  Product p2 = new Product();
		p2.setDescription("Good Notebook");
		p2.setImageLink("resources/images/notebook (2).jpg");
		p2.setPrice(6323.98);
		p2.setProductName("Nokia");
		p2.setQuantity(32);
		p2.setProductType(pt);
		System.out.println(p2.getId()+ "!!!!!!!!!!!!!!!!!!!!!!!!!!!!11");
		productService.save(p2);
		System.out.println(p2.getId() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!22");
	
/*	Product p2 = productService.findOne((long) 1);
	p2.setProductName("iphone");
	productService.save(p2);
	*/
		
	Md5 md5 = new Md5();
	
	User u = new User();
	u.setEmail("Elamso@hame");
	u.setFirstName("Misha");
	u.setPhone("434-434");
	u.setRole(Role.ROLE_ADMIN);	
	//md5.getHash("admin");
	u.setPassword(md5.getHash("admin"));
	u.setUserName("admin");
	userService.save(u);
	
	User u1 = new User();
	u1.setEmail("Elamso@hame");
	u1.setFirstName("Misha");
	u1.setPhone("434-434");
	u1.setRole(Role.ROLE_MANAGER);
	u1.setUserName("manag");
	u1.setPassword(md5.getHash("manag"));
	userService.save(u1);
	
	User u2 = new User();
	u2.setEmail("Elamso@hame");
	u2.setFirstName("Misha");
	u2.setPhone("434-434");
	u2.setRole(Role.ROLE_LOGUSER);
	u2.setUserName("guest");
	u2.setPassword(md5.getHash("guest"));
	userService.save(u2);
	
	
	OrderItem oi1 = new OrderItem();
	OrderItem oi2 = new OrderItem();
	
	oi1.setProduct(p1);
	oi2.setProduct(p2);
	oi1.setQuantity(23);
	oi2.setQuantity(34);
	orderItemService.save(oi1);
	orderItemService.save(oi2);
	
	Set<OrderItem> ois = new HashSet<OrderItem>();
	ois.add(oi1);
	ois.add(oi2);
	
	UserOrder o1 = new UserOrder();
	o1.setOrderItem(ois);
	o1.setUser(u1);
	o1.setOrderStatus(OrderStatus.PROCESSED);
	orderService.save(o1);
	
	
//	Set<Product> prod = new HashSet<Product>();
//	prod.add(p1);
//	prod.add(p);
//	UserOrder or = new UserOrder();
//	or.setProduct(prod);
//	or.setUser(u1);
//	or.setOrderQuantity(2);
//	or.setOrderStatus(OrderStatus.PROCESSED);
//	orderService.save(or);
    }

    public ProductService getProductService() {
	return productService;
    }

    public void setProductService(ProductService productService) {
	this.productService = productService;
    }

	public ProductTypeService getProductTypeService() {
		return productTypeService;
	}

	public void setProductTypeService(ProductTypeService productTypeService) {
		this.productTypeService = productTypeService;
	}
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
