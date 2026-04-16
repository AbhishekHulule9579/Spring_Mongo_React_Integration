package com.practice.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.exception.StudentNotFoundException;
import com.practice.model.Student;
import com.practice.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	private final StudentRepository studentRepository;
	
	public StudentServiceImpl (StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(String id) {
		return studentRepository.findById(id)
				.orElseThrow(()->new StudentNotFoundException("Studnet not found with id "+id));
	}

	@Override
	public Student updateStudent(String id, Student student) {
		Student existing=getStudentById(id);
		
		existing.setName(student.getName());
		existing.setAge(student.getAge());
		existing.setCourse(student.getCourse());
		existing.setMarks(student.getMarks());
		
		return studentRepository.save(existing);
	}

	@Override
	public void deleteStudent(String id) {
		studentRepository.deleteById(id);		
	}
	
}
