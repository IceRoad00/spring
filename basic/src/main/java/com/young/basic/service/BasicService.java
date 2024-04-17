package com.young.basic.service;

public interface BasicService {
    // interface의 메서드는 반드시 public abstract 이어야 함
    // public abstract String getHello();

    // public abstract 제어자는 생략해도 됨
    String getHello();
    String getApple();

    String getJwt(String principle);
    String jwtValidate(String jwt);

}
