package com.example.board.service;

import org.springframework.http.ResponseEntity;

import com.example.board.dto.request.auth.SignUpRequestDto;
import com.example.board.dto.response.ResponseDto;

public interface AuthService {
    ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);

    
}
