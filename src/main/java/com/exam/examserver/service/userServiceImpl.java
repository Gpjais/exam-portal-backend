package com.exam.examserver.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examserver.CustomException.userFoundException;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.userRole;
import com.exam.examserver.repository.roleRepository;
import com.exam.examserver.repository.userRepository;

@Service
public class userServiceImpl implements userService{

	@Autowired
	userRepository userrepository;
	
	@Autowired
    roleRepository rolerepository;
	
	@Override
	public User createUser(User user, Set<userRole> userrole) throws Exception{
		// TODO Auto-generated method stub
		User local=userrepository.findByUsername(user.getUsername());
		if(local !=null)
		{
			System.out.println("user name already exist");
			throw new userFoundException("username is already there");
		}
		else
		{
			for(userRole ur:userrole) {
				rolerepository.save(ur.getRole());
			}
			
			user.getUserroles().addAll(userrole);
			local=this.userrepository.save(user);
			System.out.println("user data is saved");
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		User user=userrepository.findByUsername(username);
		return user;
	}

	



}
