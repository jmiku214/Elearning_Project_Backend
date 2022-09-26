package com.spring.elearning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String contentsName;
	
	@Lob
	private byte[] data;
	
	private String fileName;
	
	@OneToOne
	private Courses courses;

	public Contents(String contentsName, byte[] data) {
		super();
		this.contentsName = contentsName;
		this.data = data;
	}
	
	
}
