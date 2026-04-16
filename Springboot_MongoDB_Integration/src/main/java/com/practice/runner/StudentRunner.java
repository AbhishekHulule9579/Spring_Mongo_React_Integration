package com.practice.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.practice.model.Student;
import com.practice.repository.StudentRepository;

@Component
public class StudentRunner implements CommandLineRunner{
	
	private final StudentRepository studentRepository;

	public StudentRunner(StudentRepository studentRepository) {
	    this.studentRepository = studentRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//StudentRepository studentRepository=new 
		while(true) {
			System.out.println("\n============Student Menu===============");
			System.out.println("1) Add Student");
			System.out.println("2) View All Student");
			System.out.println("3) Search By Name");
			System.out.println("4) Delete by Id");
			System.out.println("5) Update Student");
			System.out.println("6) Search By Course");
			System.out.println("7) View Sorted by Age");
			System.out.println("8) Exit");
			
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1: {
				System.out.println("Enter the name");
				String name=sc.nextLine();
				
				System.out.println("Enter the Age");
				int age=sc.nextInt();
				
				sc.nextLine();
				
				System.out.println("Enter the course ");
				String course=sc.nextLine();
				
				System.out.println("Enter the marks (comma separated) ");
				String marksInput=sc.nextLine();
				List<Integer>marks=Arrays.stream(marksInput.split(","))
						.map(Integer::parseInt)
						.toList();
				
				Student student=new Student(name,age,course,marks);
				studentRepository.save(student);
				System.out.println("Student Saved");	
				break;
			}
			case 2:
			{
				List<Student>students=studentRepository.findAll();
				if(students.isEmpty()) {
					System.out.println("no student Found");
				}
				else {
					students.forEach(s->{
						System.out.println("--------------------------------");
						System.out.println("ID : "+s.getId());
						System.out.println("Name : "+s.getName());
						System.out.println("Age : "+s.getAge());
						System.out.println("Course : "+s.getCourse());
						System.out.println("Marks : "+ s.getMarks());
					});
				}
				break;
			}
			case 3:{
				System.out.println("Enter name to search ");
				String searchName=sc.nextLine();
				List<Student>result=studentRepository.findByName(searchName);
				if(result.isEmpty()) {
					System.out.println("No Student found with this name");
				}
				else {
					result.forEach(s->{
						System.out.println("ID : "+s.getId());
						System.out.println("Name : "+s.getName());
						System.out.println("Course : "+s.getCourse());
					});
				}
				break;
			}
			case 4:
				System.out.println("Enter Id to delete");
				String id=sc.nextLine();
				studentRepository.deleteById(id);
				
				System.out.println("Student deleted");
				break;
			case 5:
				System.out.println("Enter ID to update ");
				String id1=sc.nextLine();
				Optional<Student>optional =studentRepository.findById(id1);
				if(optional.isPresent()) {
					Student s=optional.get();
					System.out.println("Enter new name ");
					s.setName(sc.nextLine());
					System.out.println("Enter new age");
					int age=sc.nextInt();
					sc.nextLine();
					s.setAge(age);
					System.out.println("Enter new Course");
					s.setCourse(sc.nextLine());
					System.out.println("Enter new marks (comma separated)");
					String marksInput=sc.nextLine();
					List<Integer>marks=Arrays.stream(marksInput.split(","))
							.map(Integer::parseInt)
							.toList();
					s.setMarks(marks);
					studentRepository.save(s);
					
					System.out.println("Student detail updated");
				}else {
					System.out.println("No student found");
				}
				break;
				
			case 6:
				System.out.println("Enter the course to search");
				String course=sc.nextLine();
				
				List<Student>list=studentRepository.findByCourse(course);
				if(list.isEmpty()) {
					System.out.println("No student found in this course");
				}
				else {
					list.forEach(s->{
						System.out.println(s.getName()+"----->"+s.getCourse());
					});
				}
				break;
				
			case 7:
				List<Student>sorted=studentRepository.findAll()
				.stream()
				.sorted((a,b)->a.getAge()-b.getAge())
				.toList();
				
				sorted.forEach(s->{
					System.out.println(s.getName()+" -Age "+s.getAge());
				});
				break;
				
			case 8:
				System.out.println("Exiting");
				return;
			default:
				System.out.println("Invalid choice !");
			}
		}
	}
	
}



/*
 

	private final StudentRepository studentRepository;
	
	public StudentRunner (StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student student=new Student(
			"Abhishek",
			22,
			"BE IT",
			Arrays.asList(80,85,75)
		);
		
		studentRepository.save(student);
		
		System.out.println("Student inserted successfully");
		
		System.out.println("\n All student");
		studentRepository.findAll().forEach(s->{
			System.out.println("-------------------");
			System.out.println("ID : "+s.getId());
			System.out.println("Name : "+s.getName());
			System.out.println("Age : "+s.getAge());
			System.out.println("Course : "+s.getCourse());
			System.out.println("Marks : "+s.getMarks());
		});
	}


*/