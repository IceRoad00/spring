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

@Entity(name = "comment")
@Table(name = "commnet")
public class CommentEntity {
    @Id
    private String commentNumber;
    private String contents;
    private String writeDatetime;
    private String userEmail;
    private String boardNumber;
    
}
