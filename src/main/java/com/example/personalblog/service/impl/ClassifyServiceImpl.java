package com.example.personalblog.service.impl;

import com.example.personalblog.entity.Classify;
import com.example.personalblog.mapper.ClassifyMapper;
import com.example.personalblog.repository.ClassifyRepository;
import com.example.personalblog.service.ClassifyService;
import com.example.personalblog.vo.DisplayClassify;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    ClassifyRepository classifyRepository;

    @Autowired
    ClassifyMapper classifyMapper;

    @Override
    public PageInfo<DisplayClassify> findAllClassify(int pageNum, String str) {
        PageHelper.startPage(pageNum, 10);
        List<DisplayClassify> classifyList = classifyMapper.findAllClassify(str);
        return new PageInfo<>(classifyList);
    }

    @Override
    public List<Classify> findAll() {
        return classifyRepository.findAll();
    }

    @Override
    public void saveClassify(Classify classify) {
        classifyRepository.save(classify);
    }

    @Override
    public void deleteClassify(int id) {
//        classifyRepository.delete(id);
        classifyRepository.deleteByClid(id);
    }

    @Override
    public Classify findClassify(int id) {
        return classifyRepository.findByClid(id);
    }

    @Override
    public void update(String name, int id) {
        classifyRepository.update(name, id);
    }
}
