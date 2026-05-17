package com.demo.student_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.student_service.model.Student;
import com.demo.student_service.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	private final StudentRepository repo;
	public StudentController(StudentRepository repo) {
		this.repo=repo;
	}
	
	@GetMapping("/{id}")
	public Student get(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
	}
	
	@GetMapping("/by-cnie/{cnie}")
	public Student byCnie(@PathVariable String cnie) {
		return repo.findByCnie(cnie).orElse(null);
	}
	

}
