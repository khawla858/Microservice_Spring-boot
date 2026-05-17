package com.demo.course_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.course_service.model.Course;
import com.demo.course_service.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	private final CourseRepository repo;
	public CourseController(CourseRepository repo) {
		this.repo=repo;
	}
	
	@GetMapping("/{id}")
	public Course get(@PathVariable Long id) {
		return repo.findById(id).orElse(null);
	}
	
	@GetMapping
	public List<Course> all() {
		return repo.findAll();
	}

}
