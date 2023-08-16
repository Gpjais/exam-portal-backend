package com.exam.examserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examserver.CustomException.userFoundException;
import com.exam.examserver.configuration.jwtUtil;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.jwtRequest;
import com.exam.examserver.entity.jwtResponse;
import com.exam.examserver.service.userDetailsServiceImpl;
import com.exam.examserver.service.userService;

@RestController
@CrossOrigin("*")
public class AuthenticateControler {
	
	@Autowired
	userService us;
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	@Autowired
	private userDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private jwtUtil jwtUtils;
	
	
	//return the details of current user
		@GetMapping("/current-user/{username}")
		public User getCurrentUser(@PathVariable("username")  String username)
		{
			return us.getUser(username);    
		}
	
	@PostMapping("/generateToken")
	public ResponseEntity<?> generateToken(@RequestBody jwtRequest jwtRequest) throws userFoundException
	{
		this.authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		 
		UserDetails userDetails= this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
	     
		String token= this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new jwtResponse(token));	
	}
	
	
	
	private void authenticate(String username, String password)
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
}
