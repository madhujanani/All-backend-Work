package com.springbootproject.ELearningPortal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.ELearningPortal.entity.Feedback;
import com.springbootproject.ELearningPortal.entity.User1;
import com.springbootproject.ELearningPortal.repository.Feedbackrepo;
import com.springbootproject.ELearningPortal.repository.User1Repository;
@Service
public class feedbackServiceImpl implements FeedbackService {
	
   	@Autowired
     Feedbackrepo repository;

	@Override
	public List<Feedback> getfeedback() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Feedback addfeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return repository.save(feedback);
	}

	@Override
	public String deleteUserById(int id) {
		// TODO Auto-generated method stub
		Optional<Feedback> user = repository.findById(id);
		if (user.isPresent()) {
			  repository.deleteById(id);
		}		
		return null;
	}	}


