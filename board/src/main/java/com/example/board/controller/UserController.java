package com.example.board.controller;

import com.example.board.dto.request.user.PatchNicknameRequestDto;
import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.user.GetUserResponseDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    @GetMapping("/{email}")
    public ResponseEntity<? super GetUserResponseDto> getUser(
        @PathVariable("email") String email
    ) {
    ResponseEntity<? super GetUserResponseDto> response = userService.getUser(email);
    return response;
    }

    @PatchMapping("/{nickname}")
    public ResponseEntity<ResponseDto> patchNickname(
        
        @RequestBody @Valid PatchNicknameRequestDto requestBody
        
        ) {
        ResponseEntity<ResponseDto> response = userService.patchNickname(requestBody);
        return response;
    }
}