package com.young.basic.filter;

import java.io.IOException;

import org.springframework.util.StringUtils;
import org.springframework.web.client.ExtractingResponseErrorHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import com.young.basic.provider.JwtProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// OncePerReqeustFilter :
// - 해당 클래스를 필터 클래스로 지정하는 추상 클래스
public class JwtAuthticationFilter extends OncePerRequestFilter{

    private final JwtProvider jwtProvider;


    // 1. 클라이언트가 인증 토큰을 발급받음
    // 2. 인증 토큰을 발급받은 후 매 요청마다 인증 토큰을 request header의 authorization 필드의 값으로 Bearer 토큰을 포함하여 요청
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        try {

            // 1. request 객체에서 token 가져오기 -> 호출하면 token 반환 받음
            String token = ParseBearerToken(request);
            if(token == null) {
                return;
            }
            // 2. token 검증
            String subject = jwtProvider.validation(token);
            if(subject == null) {
                return;
            }

        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }


    // 1. request 객체에서 header를 가져옴
    // 2. 가져온 header에서 'authorization' 필드를 검색
    // 3. 검색한 'authorization' 값에서 'Bearer' 이후의 값을 토큰으로 가져옴
    private String ParseBearerToken(HttpServletRequest request) {
        
        // 1. request header의 'authorization' 필드 값을 가져옴
        String authorization = request.getHeader("authorization");
        // authorization 필드의 값이 존재하는지 여부
        // null 여부, 빈 문자열 여부, 공백 문자열 여부 -> 있다면 false가 나옴
        boolean hasauthorization = StringUtils.hasText(authorization);
        if(!hasauthorization) return null;

        // 현재 요청이 Bearer Token Authtication이 맞는지 확인
        // 문자열의 시작이 'Bearer '로 시작하는지 여부
        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;

        // 2. 'authorization' 필드 값에서 'Bearer ' 이후의 값을 가져옴
        String token = authorization.substring(7);
        return token;
    }
}
