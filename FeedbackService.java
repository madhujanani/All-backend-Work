package com.springbootproject.ELearningPortal.service;

import java.util.List;

import com.springbootproject.ELearningPortal.entity.Feedback;
import com.springbootproject.ELearningPortal.entity.User1;

public interface FeedbackService {
	
	List<Feedback> getfeedback();
	Feedback addfeedback(Feedback feedback);
	String deleteUserById(int id);

}
