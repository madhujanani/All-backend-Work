package com.springbootproject.ELearningPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.ELearningPortal.entity.Contact;
import com.springbootproject.ELearningPortal.repository.ContactRepo;

@Service
public class ContactServiceImlp implements ContactService{
	
	@Autowired
    ContactRepo repository;
	
	@Override
	public List<Contact> getContacts() {
		// TODO Auto-generated method stub
		return repository.findAll();	}

	@Override
	public Contact addContact(Contact contact) {
		// TODO Auto-generated method stub
		return repository.save(contact);	}

}
