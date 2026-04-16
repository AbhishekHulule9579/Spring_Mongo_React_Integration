package com.practice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Document(collection="students")  // this is the collections name which will be created in the mongo DB
public class Student {
	
	@Id
	private String id;
	
	@NotBlank
	private String name;
	
	@Min(1)
	private int age;
	
	@NotBlank
	private String course;
	
	private List<Integer>marks;
	
	public Student() {
		//super();
		// TODO Auto-generated constructor stub
	}

	public Student( String name, int age, String course, List<Integer> marks) {
		super();
	
		this.name = name;
		this.age = age;
		this.course = course;
		this.marks = marks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}

}
