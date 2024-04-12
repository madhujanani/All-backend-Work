package com.springbootproject.ELearningPortal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.ELearningPortal.entity.User1;
import com.springbootproject.ELearningPortal.repository.User1Repository;

@Service
public class User1ServiceImpl implements User1Service{
	
	@Autowired
	User1Repository repository;
	
	@Override
	public List<User1> getUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User1 addUser(User1 user) {
		// TODO Auto-generated method stub
		return repository.save(user);
	}

	@Override
	public User1 getUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User1> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	@Override
	public void updateUser(int id, User1 user) {
		// TODO Auto-generated method stub
		Optional<User1> findById = repository.findById(id);
		if (findById.isPresent()) {
			User1 userobject = findById.get();
			userobject.setName(user.getName());
			userobject.setPhoneNo(user.getPhoneNo());
			userobject.setEmail(user.getEmail());
			userobject.setAddress(user.getAddress());
			userobject.setDate(user.getDate());
			userobject.setPassword(user.getPassword());
			userobject.setUploadPhoto(user.getUploadPhoto());
			repository.save(userobject);
		} else {
			System.out.println("No data found to update");
		}
	
	}

//	@Override
//	public User1 getUserByFirstName(String firstname) {
//		// TODO Auto-generated method stub
//		return repository.findByFirstName(firstname);
//
//	}

	@Override
	public String deleteUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User1> user = repository.findById(id);
		if (user.isPresent()) {
			  repository.deleteById(id);
		}		
		return null;
	}

}
