package com.example.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.board.entity.CommnetEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommnetEntity, Integer>{
    
}
