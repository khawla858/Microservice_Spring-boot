package com.demo.enrollment_service.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.enrollment_service.clients.CourseClient;
import com.demo.enrollment_service.clients.StudentClient;
import com.demo.enrollment_service.dtos.CourseDTO;
import com.demo.enrollment_service.dtos.EnrollmentResponseDTO;
import com.demo.enrollment_service.dtos.StudentDTO;
import com.demo.enrollment_service.repository.EnrollmentRepository;
import com.demo.enrollment_service.entities.Enrollment;
import java.time.Duration;


@Service
public class EnrollmentService {

    public final EnrollmentRepository repo;
    public final StudentClient studentClient;
    public final CourseClient courseClient;

    public EnrollmentService(EnrollmentRepository repo,
                             StudentClient studentClient,
                             CourseClient courseClient) {
        this.repo = repo;
        this.studentClient = studentClient;
        this.courseClient = courseClient;
    }

    public EnrollmentResponseDTO enroll(Long studentId, Long courseId) {

        StudentDTO s = studentClient.getStudent(studentId);
        CourseDTO c = courseClient.getCourse(courseId);
        
     // 3. ✅ AJOUTER ICI : Vérifier que l'étudiant n'est pas déjà inscrit à ce cours
        if (repo.existsByStudentIdAndCourseId(studentId, courseId)) {
            throw new RuntimeException("You are already enrolled in this course");
        }

        if (repo.countByCourseId(courseId) >= 3)
            throw new RuntimeException("Course full");

        Enrollment e = new Enrollment();
        e.setStudentId(studentId);
        e.setCourseId(courseId);
        e.setEnrollmentDate(LocalDateTime.now());

        repo.save(e);

        return buildDTO(e, s, c);
    }

    public List<EnrollmentResponseDTO> getMyEnrollments(Long studentId) {

        return repo.findByStudentId(studentId)
                .stream()
                .map(e -> {
                    StudentDTO s = studentClient.getStudent(e.getStudentId());
                    CourseDTO c = courseClient.getCourse(e.getCourseId());
                    return buildDTO(e, s, c);
                })
                .collect(Collectors.toList());
    }

    private EnrollmentResponseDTO buildDTO(Enrollment e,
                                           StudentDTO s,
                                           CourseDTO c) {
    	
    	 // DEBUG - Afficher les valeurs reçues
        System.out.println("========== DEBUG ==========");
        System.out.println("Enrollment ID: " + e.getId());
        System.out.println("Student CNIE: " + (s != null ? s.getCnie() : "NULL"));
        System.out.println("Course object: " + (c != null ? c.toString() : "NULL"));
        System.out.println("Course ID: " + (c != null ? c.getId() : "NULL"));
        System.out.println("Course Title from DTO: " + (c != null ? c.getTitle() : "NULL"));
        System.out.println("===========================");

        EnrollmentResponseDTO dto = new EnrollmentResponseDTO();
        dto.setEnrollmentId(e.getId());
        dto.setStudentCnie(s.getCnie());
        dto.setCourseName(c.getTitle());
        dto.setDate(e.getEnrollmentDate().toString());

        boolean deletable =
                Duration.between(e.getEnrollmentDate(), LocalDateTime.now()).toHours() < 24;

        dto.setDeletable(deletable);

        return dto;
    }
    
    public void deleteEnrollment(Long enrollmentId) {
        Enrollment enrollment = repo.findById(enrollmentId)
            .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        
        // Vérifier la règle des 24h avant suppression
        boolean deletable = Duration.between(enrollment.getEnrollmentDate(), LocalDateTime.now()).toHours() < 24;
        
        if (!deletable) {
            throw new RuntimeException("Cannot delete enrollment older than 24 hours");
        }
        
        repo.deleteById(enrollmentId);
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    public int getEnrollmentCount(Long courseId) {
        return (int) repo.countByCourseId(courseId);
    }
    
}
