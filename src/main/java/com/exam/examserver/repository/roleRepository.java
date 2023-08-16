package com.exam.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examserver.entity.Role;

@Repository
public interface roleRepository extends JpaRepository<Role, Long>{
 
	   
}
