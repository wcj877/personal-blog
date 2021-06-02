package com.example.personalblog.service;

import com.example.personalblog.entity.Label;
import com.example.personalblog.vo.DisplayLabel;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface LabelService {

    //分页
    PageInfo<DisplayLabel> findAllLabel(int pageNum, String str);

    List<Label> findAll();

    void saveLabel(Label label);

    void updateLabel(int id, String name);

    void deleteById(int id);

    Label findByLid(int id);

}
