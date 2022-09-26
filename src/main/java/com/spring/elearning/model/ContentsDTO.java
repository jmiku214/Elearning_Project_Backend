package com.spring.elearning.model;

import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentsDTO {
	
	private String contentsName;
	
	private String courseName;

}
