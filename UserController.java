package com.springbootproject.ELearningPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.ELearningPortal.entity.User1;
import com.springbootproject.ELearningPortal.service.User1Service;

@RestController
@RequestMapping("/user1")
//@CrossOrigin(origins = "//localhost:3000")  //we can have this globally by creatig a bean in our main methodwhich is elearningPortalapplication .jave
public class UserController {

	@Autowired
	User1Service service;
	
	
	@GetMapping("/users")
	public ResponseEntity< List<User1> >users(){  // as we need to give the httpstatus to client,, we should not use thes user class object directly,,so we are using ResponseEntity to also send the httpstatus.
		/*List<User> userList = new ArrayList<>();
		userList.add(new User("Anu","shar",23,'F'));
		userList.add(new User("Banu","var",25,'F'));
		userList.add(new User("caleb","nox",26,'M'));
		userList.add(new User("david","bro",27,'M'));
		userList.add(new User("emiley","ethan",25,'F'));*/
		List <User1>userList = service.getUsers();
		return  new ResponseEntity<>(userList,HttpStatus.OK);
		}
	
	@PostMapping("/user")//to create a new row of record
	public ResponseEntity<User1> addUser(@RequestBody User1 user){
		User1 newUser = service.addUser(user);
		return  new ResponseEntity<>(newUser,HttpStatus.CREATED);//if we dont wantresponse back then avoid newUser
	}
	@GetMapping("/user/{id}")//get the row by unique id
	public ResponseEntity<User1>getUserById(@PathVariable("id")int id){
		return new ResponseEntity<>(service.getUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")// to update any date in table
	public ResponseEntity updateUser(@PathVariable("id")int id,@RequestBody User1 user) {
		service.updateUser(id,user);
		return new ResponseEntity(HttpStatus.OK);	
	}
//	@GetMapping("/user/byName/{firstName}")//get the data by  firstname
//	public ResponseEntity<User1> getUserByName(@PathVariable("firstName") String firstName){
//		 return new ResponseEntity<>(service.getUserByFirstName(firstName),HttpStatus.OK);		
//		 }
	@DeleteMapping("/user/{id}")
	public ResponseEntity deleteUserById(@PathVariable("id")int id) {
		service.deleteUserById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);	
	}
	
}
