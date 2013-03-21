package com.duckranger.goodproject.service;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.duckranger.goodproject.domain.Product;
import com.duckranger.goodproject.domain.ProductType;
import com.duckranger.goodproject.repository.ProductRepository;
import com.duckranger.goodproject.repository.ProductTypeRepository;

@Service

public class ProductService {
	 private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	 private static final int PAGE_SIZE = 9;	
	 private static int lastId = 3;	
	    @Autowired
	    private ProductRepository productRepository;
	    
	    @Autowired
	    private ProductTypeRepository productTypeRepository;

	    public Iterable<Product> findAll() {
	    	return productRepository.findAll();
	    }
	   
	    public Page<Product> findAllA(Integer pageNumber,String s) {
	    	 PageRequest request =
	    	            new PageRequest(pageNumber-1, PAGE_SIZE, Sort.DEFAULT_DIRECTION.ASC, s);
	    	
	    	return productRepository.findAll(request);
	    }
	    
	    public Page<Product> findAllD(Integer pageNumber, String s) {
	    	 PageRequest request =
	    	            new PageRequest(pageNumber-1, PAGE_SIZE, Sort.DEFAULT_DIRECTION.DESC, s);
	    	
	    	return productRepository.findAll(request);
	    }
	    
	    public Page<Product> findByTypeA(Integer pageNumber,String s, ProductType productType) {
	    	 PageRequest request =
	    	            new PageRequest(pageNumber-1, PAGE_SIZE, Sort.DEFAULT_DIRECTION.ASC, s);
	    	
	    	return productRepository.findByProductType(productType,request);
	    }
	    
	    public Page<Product> findByTypeD(Integer pageNumber,String s, ProductType productType) {
	    	 PageRequest request =
	    	            new PageRequest(pageNumber-1, PAGE_SIZE, Sort.DEFAULT_DIRECTION.DESC, s);
	    	
	    	return productRepository.findByProductType(productType,request);
	    }
	    
	    public Page<Product> findByPriceA(Integer pageNumber,String s, Double l, Double m) {
	    	 PageRequest request =
	    	            new PageRequest(pageNumber-1, PAGE_SIZE, Sort.DEFAULT_DIRECTION.ASC, s);
	    	
	    	return productRepository.findByPriceBetween(l,m,request);
	    }
	    public Page<Product> findByPriceD(Integer pageNumber,String s, Double l, Double m) {
	    	 PageRequest request =
	    	            new PageRequest(pageNumber-1, PAGE_SIZE, Sort.DEFAULT_DIRECTION.DESC, s);
	    	
	    	return productRepository.findByPriceBetween(l,m,request);
	    }
	    	
	    public Page<Product> findByTypePriceASC(Integer pageNumber,String s, ProductType productType, Double l, Double m) {
	    	 PageRequest request =
	    	            new PageRequest(pageNumber-1, PAGE_SIZE, Sort.DEFAULT_DIRECTION.ASC, s);
	    	
	    	return productRepository.findByProductTypeAndPriceBetween(productType,l,m,request);
	    }
	    public Page<Product> findByTypePriceDESC(Integer pageNumber,String s, ProductType productType, Double l, Double m) {
	    	 PageRequest request =
	    	            new PageRequest(pageNumber-1, PAGE_SIZE, Sort.DEFAULT_DIRECTION.DESC, s);
	    	
	    	return productRepository.findByProductTypeAndPriceBetween(productType,l,m,request);
	    }
	    	    	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	    public Product save(Product t) {
	    	return productRepository.save(t);
	    }

	    public void delete(Long id) {
	    	productRepository.delete(id);
	    }

	    public Product findOne(Long id) {
	    	return productRepository.findOne(id);
	    }
	    public void EditProduct(int i, String name, Double price, Integer quantity, String description, String type, String link){
	    	Product p = findOne(new Long(i));
			Iterable<ProductType> p1 = productTypeRepository.findAll();
			for (ProductType a : p1) {
				if (a.getProductType().equalsIgnoreCase(type)) {
					p.setProductType(a);
					break;
				}
			}
			
			Date date =Calendar.getInstance().getTime();		
			if(p.getAddDate()==null){				
				p.setAddDate(date);
			}else{
				p.setEditDate(date);
			}
			
			p.setProductName(name);
			p.setPrice(price);
			p.setDescription(description);
			p.setQuantity(quantity);
			p.setImageLink(link);
			save(p);
	    }	    
	    
	    
	    public String addProduct(String name, Double price, Integer quantity, String description, String type, String link){
	    	Product p = new Product();
			Iterable<ProductType> p1 = productTypeRepository.findAll();
			for (ProductType a : p1) {
				if (a.getProductType().equalsIgnoreCase(type)) {
					p.setProductType(a);
					break;
				}
			}
			
			Date date =Calendar.getInstance().getTime();			
			p.setAddDate(date);
			
			p.setProductName(name);
			p.setPrice(price);
			p.setDescription(description);
			p.setQuantity(quantity);
			String s = p.getProductType().getProductType();
			System.out.println(s+"     DS~!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
			if(s.equals("Телевизоры"))
				p.setImageLink("resources/images/tv.jpg");
			else if (s.equals("Телефоны"))
				p.setImageLink("resources/images/mobile.jpg");
			else if (s.equals("Ноутбуки"))
				p.setImageLink("resources/images/notebook (2).jpg");
			else p.setImageLink("resources/images/tv.jpg");
			
			
			/*p.setImageLink(link);*/
			save(p);
			return p.getId().toString();
	    }	  
	    
	    public void deleteProductByName(String name){
	    	Iterable<Product> p = findAll();
			for (Product a : p) {
				if (a.getProductName().equalsIgnoreCase(name)){
					delete(a.getId());
					break;
				}
			}
	    } 
	    public String getAllId(){
	    	String result="";
	    	Iterable<Product> p = productRepository.findAll();
			for (Product a : p) {
				result=result+a.getId().toString()+",";				
				}
			return result;
			}
	
	   
	    
	    public List<Product> findAllByTypeProduct(Long type){
	    	List<Product> col=new ArrayList<Product>();	   
	    		for(Product p: findAll()){		    	    			
	    			if(p.getProductType().getId()==type){
	    				col.add(p);
	    			}	    			
	    		}	    	
	    	return col;
	    }
	    
	    public Set<Product> searchProduct(String nameProduct){	    	
	    	String searchNameProduct= nameProduct.toUpperCase();	    	
	    	Iterable<Product> lastarray =findAll();
	    	Set<Product> col=new HashSet<Product>();	  	    	
	    	for(Product p: lastarray){
	    		String newAll=(p.getProductName()+p.getPrice().toString()+
	    										p.getDescription()+p.getProductType().getProductType()).toUpperCase();
	    		if (newAll.indexOf(searchNameProduct)>(-1)){
	    			col.add(p);	 	    			
	    		}	    		
	    	}
	    	if(col.isEmpty()){
	    		String[] array=searchNameProduct.split(" ");	    		
	    			for(String s: array){	 	    				
	    				for(Product p: lastarray){	    					
	    					String newAll=(p.getProductName()+p.getPrice().toString()+
	    										p.getDescription()+p.getProductType().getProductType()).toUpperCase();
	    					if (newAll.indexOf(s)>(-1)){	    						
	    		    			col.add(p);	 	    			
	    		    		}	
	    				}
	    				
	    			}
	    	}
	    
	    	return col;
	    }
	    	    
	    public void UploadFile(MultipartFile file,HttpServletRequest request,
	            HttpSession session, Integer id){	    	
	    	 String orgName = file.getOriginalFilename();	  
	    	 if((!orgName.equalsIgnoreCase("")) && ((orgName.indexOf(".gif")>(-1))||(orgName.indexOf(".jpg")>(-1))||(orgName.indexOf(".png")>(-1)))){		
	    		 	Integer y=0;
	    		 	ServletContext context = session.getServletContext();
		    	    String realContextPath = context.getRealPath("/");		    	  
		    	    String filePath =  realContextPath +"resources\\images\\"+orgName;
		    	    Collection<Product> t = (Collection<Product>)findAll();
		    	    if (id==0){		    	    
		    	    	if(lastId!=t.size()){
		    	    		y=t.size();
		    	    		lastId=y;		
		    	    	}		    	    	
		    	    }else{
		    	    	y=id;
		    	    }		    	  		    	   
		    	    for(Product e: t){
		    	    	if(e.getId().intValue()==(y)){    	
		    	    		e.setImageLink("resources/images/"+orgName);
		    	    		save(e);
		    	    		break;
		    	    	}
		    	    }		    	    	    	    
		  	     File dest = new File(filePath);	  
		         try {
			         file.transferTo(dest);
			         } catch (IllegalStateException e) {
			        	 e.printStackTrace();
			         } catch (IOException e) {
			        	 e.printStackTrace();
			         }
		    	    }
	    	 
	    }
	   	    

//    public void AddFromFile(HttpServletRequest request){
//    	    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
//    	    String filename = getFilename(filePart);
//    	    InputStream filecontent = filePart.getInputStream();
//    	    // ... (do your job here)
//    	}
//
//    	private static String getFilename(Part part) {
//    	    for (String cd : part.getHeader("content-disposition").split(";")) {
//    	        if (cd.trim().startsWith("filename")) {
//    	            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
//    	            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
//    	        }
//    	    }
//    	    return null;
//    	}

	    
}
