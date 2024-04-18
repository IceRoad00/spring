package com.young.basic.service.implement;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.young.basic.entity.CustomOAuth2User;

// OAuth2.0 인증 결과를 비즈니스 로직에 사용하는 서비스
// DefaultOAuth2UserService를 확장하여 작성
@Service
public class OAuth2UserServiceImplement extends DefaultOAuth2UserService {

    // loadUser 메서드 :
    // - OAuth2.0 인증 성공 시에 인증 서버로부터 받은 request 객체를 사용하여 해당 서비스에 클라이언트 정보를 로드하는 작업
    @Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        String oauthClientName = userRequest.getClientRegistration().getClientName();
        System.out.println(oauthClientName);
        
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String name = (String) oAuth2User.getAttributes().get("login");

        return new CustomOAuth2User(name, oAuth2User.getAttributes(), oAuth2User.getAuthorities());
    }
    
}
