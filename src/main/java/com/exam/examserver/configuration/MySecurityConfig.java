package com.exam.examserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.examserver.service.userDetailsServiceImpl;

@Configuration
@EnableWebSecurity 
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	   
	    @Autowired
	    private jwtAuthenticationFilter jwtAuthenticationFilter;
	   
	   @Autowired
	    private jwtAuthenticationEntryPoint  unAuthorisedhandler;
	
	    @Autowired
	    private userDetailsServiceImpl userDetailsServiceImpl;
	
	    @Bean
        public PasswordEncoder  passwordEncoder()
        {
        	return NoOpPasswordEncoder.getInstance();
        }
	    
        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	
        	http
        	
        	    .cors()
        	    .disable()
        	    .csrf()
        	    .disable()
        	    .authorizeRequests()
        	    .antMatchers("/generateToken","/user/").permitAll()
        	    .antMatchers(HttpMethod.OPTIONS).permitAll()
        	    .anyRequest().authenticated()
        	    .and()
        	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        	    .and()
        	    .exceptionHandling().authenticationEntryPoint(unAuthorisedhandler);
        	
        	  
        	http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        	  
        	
        	    
        	    
        }
        
        
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
          auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
        }
        
        @Bean
    	public AuthenticationManager authenticationManager() throws Exception
    	{
    		return super.authenticationManager();
    	}
        
        
}
