package com.example.personalblog.service;

import antlr.collections.impl.LList;
import com.example.personalblog.entity.Classify;
import com.example.personalblog.vo.DisplayClassify;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClassifyService {

    //分页
    PageInfo<DisplayClassify> findAllClassify(int pageNum, String str);

    List<Classify> findAll();

    void saveClassify(Classify classify);

    void deleteClassify(int id);

    Classify findClassify(int id);

    void update(String name, int id);

}
