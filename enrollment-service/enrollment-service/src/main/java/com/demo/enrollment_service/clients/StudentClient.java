package com.demo.enrollment_service.clients;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.enrollment_service.dtos.StudentDTO;

@Service
public class StudentClient {

    private final WebClient webClient;

    public StudentClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public StudentDTO getStudent(Long id) {
        return webClient.get()
                .uri("http://student-service/students/" + id)  // ← Utilise le nom du service, plus localhost
                .retrieve()
                .bodyToMono(StudentDTO.class)
                .block();
    }
}