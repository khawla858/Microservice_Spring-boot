package com.demo.enrollment_service.clients;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.enrollment_service.dtos.CourseDTO;

@Service
public class CourseClient {

    private final WebClient webClient;

    public CourseClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public CourseDTO getCourse(Long id) {
        return webClient.get()
                .uri("http://localhost:8082/courses/" + id)
                .retrieve()
                .bodyToMono(CourseDTO.class)
                .block();
    }
}