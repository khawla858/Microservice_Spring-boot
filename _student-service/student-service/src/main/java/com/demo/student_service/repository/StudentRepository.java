package com.demo.student_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.student_service.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
	Optional<Student> findByCnie(String cnie);

}
