package com.springbootproject.ELearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.ELearningPortal.entity.User1;

public interface User1Repository extends JpaRepository<User1,Integer>{

	//User1 findByFirstName(String name);

}
