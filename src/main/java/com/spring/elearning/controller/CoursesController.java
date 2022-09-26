package com.spring.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.elearning.model.Courses;
import com.spring.elearning.service.CoursesService;

@RestController
@RequestMapping("/api")
public class CoursesController {

	@Autowired
	private CoursesService coursesService;
	
	@GetMapping("/courses/getAll")
	public ResponseEntity<?> getAllCourses(Authentication authentication){
		List<Courses> course=coursesService.getAll();
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
}
