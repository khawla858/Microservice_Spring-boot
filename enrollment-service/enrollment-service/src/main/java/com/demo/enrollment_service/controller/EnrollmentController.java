package com.demo.enrollment_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.enrollment_service.dtos.EnrollmentRequest;
import com.demo.enrollment_service.dtos.EnrollmentResponseDTO;
import com.demo.enrollment_service.services.EnrollmentService;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

  private final EnrollmentService service;
  public EnrollmentController(EnrollmentService service) {
	  this.service=service;
  }

  @PostMapping("/enroll")
  public EnrollmentResponseDTO enroll(@RequestBody EnrollmentRequest req){
    return service.enroll(req.getStudentId(), req.getCourseId());
  }

  @GetMapping("/student/{id}")
  public List<EnrollmentResponseDTO> get(@PathVariable Long id){
    return service.getMyEnrollments(id);
  }
  @GetMapping("/test")
  public String test(){
    return "ok";
  }
  ////////////////////////////////////////////////////////////////////////
  @GetMapping("/course/{courseId}/count")
  public int getEnrollmentCount(@PathVariable Long courseId) {
      return service.getEnrollmentCount(courseId);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){
    service.deleteEnrollment(id);
  }
  
}