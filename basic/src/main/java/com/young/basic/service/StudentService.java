package com.young.basic.service;

import org.springframework.http.ResponseEntity;

import com.young.basic.dto.request.student.PostStudentRequestDto;

public interface StudentService {
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
}
