package com.springbootproject.ELearningPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.ELearningPortal.entity.Contact;
import com.springbootproject.ELearningPortal.service.ContactService;


@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	ContactService service;
	
	
	
	@GetMapping("/seecontact")
	public ResponseEntity< List<Contact> >users(){  // as we need to give the httpstatus to client,, we should not use thes user class object directly,,so we are using ResponseEntity to also send the httpstatus.
			List <Contact>userList = service.getContacts();
		return  new ResponseEntity<>(userList,HttpStatus.OK);
		}
	
	@PostMapping("/addcontact")//to create a new row of record
	public ResponseEntity<Contact> addcontact(@RequestBody Contact contact){
		Contact newUser = service.addContact(contact);
		return  new ResponseEntity<>(newUser,HttpStatus.CREATED);//if we dont wantresponse back then avoid newUser
	}
}
