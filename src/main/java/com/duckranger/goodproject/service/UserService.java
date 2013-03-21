package com.duckranger.goodproject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.duckranger.goodproject.domain.Role;
import com.duckranger.goodproject.domain.User;
import com.duckranger.goodproject.repository.UserRepository;

@Service
public class UserService {
	
	 private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	 private static final int PAGE_SIZE = 9;	

		    @Autowired
		    private UserRepository userRepository;

		    public Iterable<User> findAll() {
		    	return userRepository.findAll();
		    }
		  
		    public User save(User t) {
		    	return userRepository.save(t);
		    }

		   
		    public void delete(Long id) {
		    	userRepository.delete(id);
		    }

		   
		    public User findOne(Long id) {
		    	return userRepository.findOne(id);
		    }
		  
		    

		    public Page<User> findAllU(Integer pageNumber) {
		    	 PageRequest request =
		    	            new PageRequest(pageNumber-1, PAGE_SIZE);
		    	
		    	return userRepository.findAll(request);
		    }
		  
		   		    
		    public void addUser(String firstName, String phone, String email, String role, String username){
		    	Role r=null;
				
				for (Role state : Role.values()) {
					if((state.toString()).equalsIgnoreCase(role)){
						r=state;
						break;
					}
				}				
				User user = new User();
				user.setFirstName(firstName);
				user.setPhone(phone);
				user.setEmail(email);
				user.setRole(r);
				if(!username.isEmpty()){
					user.setUserName(username);
				}
				save(user);				
		    }
		    
		  
		    public void deleteUserByName(String name){
		    	 Iterable<User> p = findAll();
				 for(User a : p){
					 if(a.getFirstName().equalsIgnoreCase(name)){
						delete(a.getId());
						break;
					 }
				 }
		    }
		    
		    public void  editUser(int i, String name, String phone, String email, String userName, String role){
		    	User u = findOne(new Long(i));   		    	
		    	for (Role state : Role.values()) {
					if((state.toString()).equalsIgnoreCase(role)){
						u.setRole(state);
						break;
					}
				}		    				    
		    	u.setFirstName(name);
		    	u.setPhone(phone);
		    	u.setEmail(email);
		    	u.setUserName(userName);
		    	save(u);	
		    }	   
		   
		    
	}

