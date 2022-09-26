package com.spring.elearning.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.elearning.model.Contents;
import com.spring.elearning.model.ContentsDTO;
import com.spring.elearning.responseData.ResponseData;
import com.spring.elearning.service.ContentsService;

@RestController
@RequestMapping("/api")
public class ContentsController {

	private ContentsService contentsService;

	public ContentsController(ContentsService contentsService) {

		this.contentsService = contentsService;
	}
	
	@PostMapping("/upload/file")
	public ResponseData uploadFile(@RequestParam("file") MultipartFile file,
			Authentication authentication,
			@RequestParam("courseName") String courseName,
			@RequestParam("contentsName") String contentsName) throws Exception {
		
		Contents attachment=null;
		String downloadURL="";
		attachment=contentsService.saveAttachment(file,courseName,contentsName);
		downloadURL=ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/download/").path(attachment.getId().toString()).toUriString();
	
		return new ResponseData(attachment.getFileName(),
				downloadURL);
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id ) throws Exception{
		Contents contents=null;
		contents=contentsService.getContents(id);
		String path = "/home/rapidsoft/Desktop/Elarning_Project/Screenshot from 2022-06-09 17-18-24.png";
	    File file = new File(path);
	    
	    		OutputStream os=new FileOutputStream(file);
	    		os.write(contents.getData());
	    		System.out.println("Succesfully data saved");
	    		os.close();
	    	
	    	
	    
		return (ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\""+contents.getFileName()
		+"\"").body(new ByteArrayResource(contents.getData())));
	}
	
	@PostMapping("/getContents/byCourseName")
	public ResponseEntity<?> getAllContentByCourseName(@RequestBody ContentsDTO contentsDTO){
	
		List<Contents> contents=contentsService.findAllByCoursesName(contentsDTO.getCourseName());
		return ResponseEntity.ok(contents);
	}
	
}
