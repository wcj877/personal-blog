package com.example.personalblog.service.impl;

import com.example.personalblog.entity.Label;
import com.example.personalblog.mapper.LabelMapper;
import com.example.personalblog.repository.LabelRepository;
import com.example.personalblog.service.LabelService;
import com.example.personalblog.vo.DisplayLabel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelMapper labelMapper;

    @Autowired
    LabelRepository labelRepository;

    @Override
    public PageInfo<DisplayLabel> findAllLabel(int pageNum, String str) {
        PageHelper.startPage(pageNum, 10);
        return new PageInfo<>(labelMapper.findAllLabel(str));
    }

    @Override
    public List<Label> findAll() {
        return labelRepository.findAll();
    }

    @Override
    public void saveLabel(Label label) {
        labelRepository.save(label);
    }

    @Override
    public void updateLabel(int id, String name) {
        labelRepository.updateLabel(id, name);
    }

    @Override
    public void deleteById(int id) {
        labelRepository.deleteById(id);
    }

    @Override
    public Label findByLid(int id) {
        return labelRepository.findByLid(id);
    }
}
