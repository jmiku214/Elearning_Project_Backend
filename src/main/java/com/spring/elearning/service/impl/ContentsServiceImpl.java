package com.spring.elearning.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.elearning.exception.ResourceNotFoundException;
import com.spring.elearning.model.Contents;
import com.spring.elearning.model.Courses;
import com.spring.elearning.repository.ContentsRepository;
import com.spring.elearning.repository.CoursesRepository;
import com.spring.elearning.service.ContentsService;

@Service
public class ContentsServiceImpl implements ContentsService {

	@Autowired
	private ContentsRepository contentsRepository;
	
	@Autowired
	private CoursesRepository coursesRepository;
	
	@Override
	public Contents saveAttachment(MultipartFile file, String courseName,String contentsName) throws Exception {
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new Exception("File Name Contains Invalid Path Sequence"+fileName);
			}
			Contents contents=new Contents();
			contents.setContentsName(contentsName);
			if(courseName!=null) {
				Courses courses=coursesRepository.findByCourseName(courseName);
				contents.setCourses(courses);
			}
			contents.setData(file.getBytes());
			contents.setFileName(file.getOriginalFilename());
			return contentsRepository.save(contents);
		}catch (Exception e) {
			throw new Exception("File is not saved"+fileName);
		}
		
	}

	@Override
	public Contents getContents(Long id) throws Exception {
		// TODO Auto-generated method stub
		return contentsRepository.findById(id).orElseThrow(() -> new Exception("file not found with id:"+id));
	}

	@Override
	public List<Contents> findAllByCoursesName(String courseName) {
		List<Contents> contents=contentsRepository.findAll();
		List<Contents> cont=new ArrayList<>();
		for(Contents c:contents) {
			if(c.getCourses().getCourseName().equals(courseName)) {
				cont.add(c);
			}
			else {
				throw new ResourceNotFoundException("Contents Is Not Found With Course Name: "+courseName);
			}
		}
		return cont;
	}

}
