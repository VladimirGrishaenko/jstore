package com.duckranger.goodproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class User extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = 1L;
	@Column(name ="FIRST_NAME")
	private String firstName = null;
	@Column(name ="PHONE")
	private String phone = null;
	@Column(name ="E_MAIL")
	private String email = null;
	
	@Column(name ="authority")
	@Enumerated(EnumType.STRING)
    private Role role=null;
	
	@Column(name ="password")
	private String password = null;
	
	@Column(name ="username")
	private String userName = "guest";
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}