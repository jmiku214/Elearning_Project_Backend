package com.spring.elearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.elearning.model.Courses;
import com.spring.elearning.repository.CoursesRepository;
import com.spring.elearning.service.CoursesService;

@Service
public class CourseServiceImpl implements CoursesService {

	@Autowired
	private CoursesRepository coursesRepository;
	
	@Override
	public List<Courses> getAll() {
		
		return coursesRepository.findAll();
	}

}
