package com.spring.elearning.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.spring.elearning.model.Contents;

public interface ContentsService {

	Contents saveAttachment(MultipartFile file,String courseName,String contentsName) throws Exception;

	Contents getContents(Long id) throws Exception;

	List<Contents> findAllByCoursesName(String courseName);

}
