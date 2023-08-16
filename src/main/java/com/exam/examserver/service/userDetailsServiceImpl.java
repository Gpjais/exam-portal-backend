package com.exam.examserver.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.examserver.entity.User;
import com.exam.examserver.repository.userRepository;

@Service
public class userDetailsServiceImpl implements UserDetailsService {

	@Autowired
	userRepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(" --- UserDetailsServiceImpl --- "+username);
		User user= userrepository.findByUsername(username);
		if(user == null)
		{
			System.out.println("User not found");
			throw new UsernameNotFoundException("No Such User Credential found");
		}
		return user;
	}

}
