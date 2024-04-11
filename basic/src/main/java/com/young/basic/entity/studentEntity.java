package com.young.basic.entity;

import com.young.basic.dto.request.student.PostStudentRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
Entity : RDBMS의 테이블과 매핑되는 클래스
웹 애플리케이션 서버와 데이터베이스 서버간의 데이터 관리를 위한 객체
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

/*
@Entity :
- 해당 클래스를 Entity 클래스로 등록하는 어노테이션
- JPA에서 데이터 관리를 위한 주된 객체
- name 속성 : Entity 클래스의 이름을 지정
*/

@Entity(name = "student")

/*
@Table :
- 해당 Entity 클래스를 RDBMS의 어떤 테이블과 매핑할지 지정하는 어노테이션
- name 속성 : 매핑할 RDBMS의 테이블명을 지정
- 만약, 클래스명 - Entity명 - Table명이 동일하면 생략 가능
*/

@Table(name = "student")

public class StudentEntity {
/*
@Id :
- Entity의 필드 중 Primary key로 사용되는 필드를 지정
*/
@Id
/*
@GeneratedValue :
- Primary key의 자동 생성 전략을 지정
- AUTO : JPA가 적절한 생성 전략을 선택
- IDENTITY : auto_icrement 전략
- SEQUENCE : 데이터베이스 sequence 전략
- TABLE : 키 생성 테이블
*/
@GeneratedValue(strategy = GenerationType.IDENTITY)

/*
@Column :
- 해당 필드를 매핑한 테이블에 어떤 컬럼과 매핑할지 지정
- name 속성 : 실제 컬럼의 이름
- nullable 속성 : null 포함 가능 여부
- unique 속성 : unique 제약 여부
- length 속성 : 컬럼의 길이
- 만약, 테이블의 컬럼명과 클래스의 필드명이 같으면 생략 가능
*/
@Column(name = "student_number", nullable = false, unique = true, insertable = false, updatable = false, length = 10)
    private Integer studentNumber;
    
    private String name; 
    private Integer age;
    private String address;
    private Boolean graduation;

    public StudentEntity(PostStudentRequestDto dto) {
        this.name = dto.getName();
        this.age = dto.getAge();
        this.address = dto.getAddress();
        this.graduation = dto.getGraduation();
    }
}