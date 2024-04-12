package com.springbootproject.ELearningPortal.service;

import java.util.List;

import com.springbootproject.ELearningPortal.entity.User1;

public interface User1Service {

	List<User1> getUsers();
	User1 addUser(User1 user);
	User1 getUserById(int id);
	void updateUser(int id,User1 user);
	//User1 getUserByFirstName(String name);
	String deleteUserById(int id);
	

	
}
