package com.example.personalblog.service;

import com.example.personalblog.entity.Comment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CommentService {

    void updateState(int id, int state);

    PageInfo<Comment> findAllComment(int pageNum, String str);

}
