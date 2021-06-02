package com.example.personalblog.repository;

import com.example.personalblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Modifying
    @Transactional
    @Query("update Comment set state=:state where cid=:id")
    public void updateState(@Param("id")int id, @Param("state")int state);


    List<Comment> findByContentContaining(String content);
}
