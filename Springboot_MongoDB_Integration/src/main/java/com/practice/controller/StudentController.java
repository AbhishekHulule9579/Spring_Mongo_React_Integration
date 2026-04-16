package com.practice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Student;
import com.practice.repository.StudentRepository;
import com.practice.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;
	
	public StudentController(StudentService studentRepository) {
		this.studentService=studentRepository;
	}
	
	//save student
	@PostMapping
	public Student addStudent(@Valid @RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	
	//get all student
	@GetMapping
	public List<Student>getAllStudents(){
		return studentService.getAllStudent();
	}
	
	// get student by id
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable String id) {
		return studentService.getStudentById(id);
	}
	
	@PutMapping
	public Student updateStudent(@PathVariable String id,@RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	//delete student by id
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable String id) {
		studentService.deleteStudent(id);
		return "Student deleted";
	}
}
