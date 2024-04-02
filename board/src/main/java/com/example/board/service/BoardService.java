package com.example.board.service;

import com.example.board.dto.response.board.GetLatestListResponseDto;

import org.springframework.http.ResponseEntity;

public interface BoardService {
    ResponseEntity<? super GetLatestListResponseDto> getLatestList();
    
}
