package com.exam.examserver.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.examserver.service.userDetailsServiceImpl;

@Component
@CrossOrigin("*")
public class jwtAuthenticationFilter extends OncePerRequestFilter {

	  
	@Autowired
	private  jwtUtil jwtUtil;
	
	@Autowired
	private  userDetailsServiceImpl userDetailsServiceImpl;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		    
		   String requestHeaderToken=request.getHeader("Authorization");
		   System.out.println("GP---requesttokenheader value :"+requestHeaderToken);
		   
		   String username=null;
		   String token=null;
		   
		   if(requestHeaderToken != null && requestHeaderToken.startsWith("Bearer "))
		   {
			   System.out.println("---"+"GYAN JAISWAL"+"---");
			   try {
			   token=requestHeaderToken.substring(7);
			   System.out.println(token);
			   username = this.jwtUtil.extractUsername(token);
			   }
			   catch(Exception e)
			   {
				   e.printStackTrace();
				   System.out.println("Exception while getting username from token");
			   }
		   }
		   else
		   {
			   System.out.println("No request header : Authorization");
		   }
		
		   if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null)
		   {
			    final UserDetails userdetails=userDetailsServiceImpl.loadUserByUsername(username);
			    if(this.jwtUtil.validateToken(token, userdetails))
			    {
			    	UsernamePasswordAuthenticationToken UsernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetailsServiceImpl,null,userdetails.getAuthorities());
			    	UsernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			    	SecurityContextHolder.getContext().setAuthentication(UsernamePasswordAuthenticationToken);
			    }
		   }
		   else
		   {
			   System.out.println("Token is not valid ");
		   }
		  
		   
		   filterChain.doFilter(request, response);
	}
 
	 
}
