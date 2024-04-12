package com.springbootproject.ELearningPortal.service;

import java.util.List;

import com.springbootproject.ELearningPortal.entity.Contact;

public interface ContactService {	

	List<Contact> getContacts();
	Contact addContact(Contact contact);

}
