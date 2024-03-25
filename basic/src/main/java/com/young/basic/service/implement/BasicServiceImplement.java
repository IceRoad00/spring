package com.young.basic.service.implement;

import org.springframework.stereotype.Service;

import com.young.basic.service.BasicService;

/* 
    Service 레이어 :
    - 실제 비즈니스 로직(연산)을 실행하는 영역
    - 트랜잭션 처리나 유효성 검사(직전 비즈니스 로직 결과에 대한)를 수행하기도 함
*/
@Service
public class BasicServiceImplement implements BasicService{

    @Override
    public String getHello() {
        return "Hello Springboot!!";
    }

    public String getApple() {
        return "Get Mappping 으로 만든 메서드";
    }


}