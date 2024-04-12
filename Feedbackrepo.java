package com.springbootproject.ELearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.ELearningPortal.entity.Feedback;

public interface Feedbackrepo extends JpaRepository<Feedback, Integer> {

}
