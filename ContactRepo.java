package com.springbootproject.ELearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.ELearningPortal.entity.Contact;

public interface ContactRepo  extends JpaRepository<Contact, Integer>{

}
