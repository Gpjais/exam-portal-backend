package com.exam.examserver.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authorities implements  GrantedAuthority {

	String authority;
	

	public Authorities(String authority) {
		super();
		this.authority = authority;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

}
