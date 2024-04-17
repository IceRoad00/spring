package com.young.basic.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

// Request Body로 받는 데이터에 대한 유효성 검사 validation 의존성을 추가해야함

public class SampleDto {
    // *해당 속성을 null이 올 수 없도록 지정
    @NotNull
    private String notNull;
    
    // *문자열일 경우 null 또는 빈 문자열이 올 수 없도록 지정
    @NotEmpty
    private String notEmpty;
    
    // *문자열일 경우 null 또는 빈 문자열 또는 공백으로 된 문자열이 올 수 없도록 지정 
    @NotBlank
    private String notBlank;

    // *RequestBody로 받아오는 데이터는 Wrapper 클래스 타입으로 데이터를 받는 것이 좋음
    @NotNull
    // *NotEmpty, NotBlank는 문자열에서만 유효함
    // @NotEmpty @NotBlank 
    private Integer requiredInt;

    // *문자열일 경우 문자열 길이의 최소 최대를 지정
    @Length(min=5, max=10)
    // *null 값이면 검사 안함
    @NotNull
    private String length;

    // *최대값과 최소값을 지정
    @NotNull
    @Max(100)
    @Min(0)
    private Integer maxMin;

    // *최대 최소 범위를 지정
    @NotNull
    @Range(min=0, max=100)
    private Integer range;

    // *문자열이 이메일 형식인지 확인
    @NotEmpty
    @Email
    private String email;

    // *정규식을 이용해 문자열의 패턴 검사를 진행
    // *전화번호, 이메일, URL, 주민등록번호, 비밀번호, 
    // *영어로만 된 문자열, 한글로만 된 문자열, 숫자로만 된 문자열
    @Pattern(regexp = "^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\\.[a-zA-Z]{2,4}$")
    private String emailPattern;
}
