package com.springbootproject.ELearningPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.ELearningPortal.entity.Course;
import com.springbootproject.ELearningPortal.entity.User1;
import com.springbootproject.ELearningPortal.service.CourseService;
import com.springbootproject.ELearningPortal.service.User1Service;


@RestController
@RequestMapping("/api/admin/course")
public class CourseController {
	
	@Autowired
	CourseService service;
	@GetMapping("/courses")	
	public ResponseEntity<List<Course>> courses(){
		List<Course> courseList = service.getCourses();
		return new ResponseEntity<>(courseList,HttpStatus.OK);		
	}
 
	@PostMapping("/course")
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		Course newCourse = service.addcourse(course);
		return  new ResponseEntity<>(newCourse,HttpStatus.CREATED);
	}
 
 
	@PostMapping("/courseList")
		public ResponseEntity <List<Course>> addCourse(@RequestBody List<Course>  courses){
		//List<Course> course = new List<>(Arrays.asList());
	 List<Course> course = service.addCourseList(courses);
 
		return  new ResponseEntity<>(course,HttpStatus.CREATED);
	//return "Posted";
	}
				
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id")int id){
		return new ResponseEntity<>(service.getCourseById(id),HttpStatus.OK);
	}
 
	@PutMapping("/course/{id}")
	public ResponseEntity updateCourse(@PathVariable("id") int id , @RequestBody Course course) {
		service.updateCourse(id, course);		
		return new ResponseEntity(HttpStatus.OK);
	}
 
	@DeleteMapping("/course/{id}")
	public ResponseEntity deleteCourse(@PathVariable("id") int id ) {
		service.deleteCourse(id);
		
		return new ResponseEntity(HttpStatus.OK);
	}
	

}
