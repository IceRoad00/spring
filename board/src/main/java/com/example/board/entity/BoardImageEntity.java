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

@Entity(name = "board_image")
@Table(name = "board_image")
public class BoardImageEntity {
    @Id
    private Integer sequence;
    private Integer boardNumber;
    private String imageUrl;
    
}
