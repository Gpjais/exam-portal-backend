package com.exam.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entity.User;

@Repository
public interface userRepository  extends JpaRepository<User, Long>{

	public User findByUsername(String username);
	
	

}
