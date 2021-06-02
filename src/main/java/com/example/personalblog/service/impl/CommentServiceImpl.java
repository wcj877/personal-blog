package com.example.personalblog.service.impl;

import com.example.personalblog.entity.Comment;
import com.example.personalblog.repository.CommentRepository;
import com.example.personalblog.service.CommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void updateState(int id,int state) {
        commentRepository.updateState(id, state);
    }

    @Override
    public PageInfo<Comment> findAllComment(int pageNum, String str) {
        PageHelper.startPage(pageNum, 10);
        return new PageInfo<>(commentRepository.findByContentContaining(str));
    }
}
