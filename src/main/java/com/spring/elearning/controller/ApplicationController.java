package com.spring.elearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationController {

	@GetMapping("/process")
	public String process() {
		return "passed the spring security through DB";
	}
}
