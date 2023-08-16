package com.exam.examserver.controller;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.CustomException.userFoundException;
import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.userRole;
import com.exam.examserver.service.userService;



@RestController
@RequestMapping(value="/user")
@CrossOrigin("*")
public class userController {
	
	@Autowired
	userService userservice;
	
	@PostMapping("/")
	public void createUser(@RequestBody User user) throws Exception
	{
		Role role=new Role();
		role.setId(45L);
		role.setRoleName("NORMAL");
		
		userRole userrole=new userRole();
		userrole.setRole(role);
		userrole.setUser(user);
		
		Set<userRole> ur=new HashSet<>();
		ur.add(userrole);
		
		userservice.createUser(user, ur);	
	}
	
	@GetMapping("/{username}")
	public User getUserByUserName(@PathVariable("username")  String username)
	{
		User u=userservice.getUser(username);
		return u;
	}
	
	
	

}
