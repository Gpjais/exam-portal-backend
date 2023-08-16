package com.exam.examserver.service;

import java.util.Set;

import com.exam.examserver.entity.User;
import com.exam.examserver.entity.userRole;

public interface userService {
	
	public User createUser(User user, Set<userRole> userrole) throws Exception;
    
	public User getUser(String username);
 
}
