package com.example.board.service.implementations;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.board.dto.request.auth.SignUpRequestDto;
import com.example.board.dto.response.ResponseDto;
import com.example.board.dto.response.user.GetUserResponseDto;
import com.example.board.entity.UserEntity;
import com.example.board.repository.UserRepository;
import com.example.board.service.AuthService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;

@Service
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService{
    
    UserEntity userEntity = new UserEntity(dto);

    @Override
    public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {

        String email = dto.getEmail();
        String nickname = dto.getNickname();
        String telNumber = dto.getTelNumber();

        try {
            // 1. 입력 받은 이메일이 테이블에 존재하는지 조회 
            // email -> (true / false)
            // 1) 1에 대한 조화결과가 true 중복된 이메일 응답처리

            // 2. 입력 받은 닉네임이 테이블에 존재하는지 조회 
            // nickname -> (true / false)
            // 1) 2에 대한 조화결과가 true 중복된 닉네임 응답처리

            // 3. 입력 받은 휴대전화번호이 테이블에 존재하는지 조회 
            // telNumber -> (true / false)
            // 1) 3에 대한 조화결과가 true 중복된 휴대전화번호 응답처리

            // 4. 유저 레코드 삽입
            // 1) 유저 엔터티의 인스턴스 생성
            // (dto) -> userEntity 인스턴스
            // 2) 유저 엔터티의 인스턴스 저장

            // 5. 성공 응답 처리
            UserEntity userEntity = userRepository.existsById(email);

            if(email) return ResponseDto.duplicateEmail();

            if(nickname) return ResponseDto.duplicateNickname();

            if(telNumber) return ResponseDto.duplicateTelNumber();

            return GetUserResponseDto.success();

        } catch(Exception exception) {
            // 데이터베이스 작업 중에 발생하는 예외 데이터베이스 에러 처리
            exception.printStackTrace();
            return ResponseDto.databaseError();
            
        }
        
    }
    
}
