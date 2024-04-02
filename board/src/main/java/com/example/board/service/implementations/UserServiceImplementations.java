package com.example.board.service.implementations;

import org.springframework.http.ResponseEntity;

import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.user.GetUserResponseDto;
import com.example.board.repository.UserRepository;
import com.example.board.service.UserService;

public class UserServiceImplementations implements UserService{
    
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetUserResponseDto> getUser(String email) {
        

        try {

            return ResponseDto.notExistUser();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.DATABASEERROR();
        }
        
    }
    
}
