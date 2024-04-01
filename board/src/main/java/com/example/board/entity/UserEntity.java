package com.example.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

@Entity(name = "user")
@Table(name = "user")
public class UserEntity {
    @Id
    private String email;
    private String password;
    private String nickname;
    private String tellNumber;
    private String address;
    private String addressDetail;
    private String profileImageUrl;
    
}
