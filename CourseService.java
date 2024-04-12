package com.springbootproject.ELearningPortal.service;

import java.util.List;

import com.springbootproject.ELearningPortal.entity.Course;

public interface CourseService {
	List<Course> getCourses();
	
	Course addcourse(Course course);
	List <Course> addCourseList(List<Course> courses);
	
	Course getCourseById(int id);
	
	void updateCourse(int id ,Course course);
	
	String deleteCourse(int id  );
 
}
