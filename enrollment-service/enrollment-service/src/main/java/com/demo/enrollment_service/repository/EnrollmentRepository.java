package com.demo.enrollment_service.repository;
import com.demo.enrollment_service.entities.Enrollment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	  long countByCourseId(Long courseId);
	  List<Enrollment> findByStudentId(Long studentId);
	}