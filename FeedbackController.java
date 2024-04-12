package com.springbootproject.ELearningPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.ELearningPortal.entity.Feedback;
import com.springbootproject.ELearningPortal.entity.User1;
import com.springbootproject.ELearningPortal.service.FeedbackService;
import com.springbootproject.ELearningPortal.service.User1Service;


@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	FeedbackService service;
	
	
	@GetMapping("/see")
	public ResponseEntity< List<Feedback> >users(){  // as we need to give the httpstatus to client,, we should not use thes user class object directly,,so we are using ResponseEntity to also send the httpstatus.
	
		List <Feedback>userList = service.getfeedback();
		return  new ResponseEntity<>(userList,HttpStatus.OK);
		}
	
	@PostMapping("/send")//to create a new row of record
	public ResponseEntity<Feedback> addUser(@RequestBody Feedback feedback){
		Feedback newUser = service.addfeedback(feedback);
		return  new ResponseEntity<>(newUser,HttpStatus.CREATED);//if we dont wantresponse back then avoid newUser
	}
	
	
	

	@DeleteMapping("/see/{id}")
	public ResponseEntity deleteUserById(@PathVariable("id")int id) {
		service.deleteUserById(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);	
	}
}
