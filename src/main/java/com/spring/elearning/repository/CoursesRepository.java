package com.spring.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.elearning.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long> {

	Courses findByCourseName(String courseName);
	
}
