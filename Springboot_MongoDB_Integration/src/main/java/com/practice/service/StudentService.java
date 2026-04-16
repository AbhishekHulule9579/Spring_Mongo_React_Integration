package com.practice.service;

import java.util.List;

import com.practice.model.Student;

public interface StudentService {

	Student addStudent(Student student);
	
	List<Student> getAllStudent();
	
	Student getStudentById(String id);
	
	Student updateStudent(String id,Student student);
	
	void deleteStudent(String id);
}
