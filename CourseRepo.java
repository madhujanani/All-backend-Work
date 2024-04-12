package com.springbootproject.ELearningPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.ELearningPortal.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
