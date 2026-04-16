package com.practice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practice.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

	List<Student> findByName(String name);
	List<Student>findByCourse(String course);
}
