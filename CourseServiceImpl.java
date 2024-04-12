package com.springbootproject.ELearningPortal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.ELearningPortal.entity.Course;
import com.springbootproject.ELearningPortal.repository.CourseRepo;

@Service
public class CourseServiceImpl  implements CourseService{
	
	
	    @Autowired
		CourseRepo repository;

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return repository.findAll();
		}

	@Override
	public Course addcourse(Course course) {
		// TODO Auto-generated method stub
		return repository.save(course);
		}

	@Override
	public List<Course> addCourseList(List<Course> courses) {
		// TODO Auto-generated method stub
		 return repository.saveAll(courses);
		 }

	@Override
	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		Optional<Course> course = repository.findById(id);
		
		if(course.isPresent()) {
			return course.get();}
		else {
			return null;
		}	}

	@Override
	public void updateCourse(int id, Course course) {
		// TODO Auto-generated method stub
		Optional<Course> oldCourse = repository.findById(id);

		if (oldCourse.isPresent()) {
			Course courseobj = oldCourse.get();
			courseobj.setCName(course.getCName());
			courseobj.setCDesp(course.getCDesp());
			courseobj.setCFees(course.getCFees());
			courseobj.setCResource(course.getCResource());	
			repository.save(courseobj);
		}
		else {
			System.out.println("No Data Found");
		}	
		}
	

	@Override
	public String deleteCourse(int id) {
		// TODO Auto-generated method stub
		 Optional<Course> deleteById= repository.findById(id);
			
			if(deleteById.isPresent()) {
				repository.deleteById(id);
				System.out.println("Course with id "+id+" has been deleted successfully" );
				return "Course with id "+id+" has been deleted successfully";
			}
			
			else {  System.out.println ("No Data Found");
			 return "No Data Found";
			}	
			}
}
