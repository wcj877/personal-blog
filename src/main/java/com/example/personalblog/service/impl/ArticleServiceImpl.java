package com.example.personalblog.service.impl;

import com.example.personalblog.entity.Article;
import com.example.personalblog.entity.ArticleLabel;
import com.example.personalblog.entity.Label;
import com.example.personalblog.mapper.ArticleMapper;
import com.example.personalblog.repository.ArticleLabelRepository;
import com.example.personalblog.repository.ArticleRepository;
import com.example.personalblog.repository.AuthorityRepository;
import com.example.personalblog.repository.LabelRepository;
import com.example.personalblog.service.ArticleService;
import com.example.personalblog.service.LabelService;
import com.example.personalblog.vo.DisplayArticle;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleLabelRepository articleLabelRepository;

    @Override
    public PageInfo<DisplayArticle> findAllArticle(int pageNum, String str) {
        PageHelper.startPage(pageNum,10);
        List<DisplayArticle> articleList = articleMapper.findAllArticle(str);
        return new PageInfo<>(articleList);
    }

    @Override
    public DisplayArticle findArticle(int id) {
        return articleMapper.findArticle(id);
    }

    @Override
    public void updateState(int id, int state) {
        articleRepository.updateState(id, state);
    }

    @Override
    public void deleteByAid(int id) {
        articleRepository.deleteByAid(id);
    }

    @Override
    public void save(Article article, int[] label) {
        int id = articleRepository.saveAndFlush(article).getAid();

        List<ArticleLabel> lists = new ArrayList<>();

        for (int i : label) {
            lists.add(ArticleLabel.builder().aid(article.getAid()).lid(i).build());
        }

        articleLabelRepository.saveAll(lists);
    }

    @Override
    public void updateArticle(Article article, int[] label) {

        articleRepository.updateArticle(article.getAid(),article.getHeadine(),article.getContent(),article.getUpdateTime(),
                article.getCoverPhoto(),article.getState(),article.getClid());

        articleLabelRepository.deleteAllByAid(article.getAid());

        List<ArticleLabel> lists = new ArrayList<>();
        for (int i : label) {
            lists.add(ArticleLabel.builder().aid(article.getAid()).lid(i).build());
        }

        articleLabelRepository.saveAll(lists);

    }

    @Override
    public PageInfo<DisplayArticle> findHottest() {
        PageHelper.startPage(1,4);
        return new PageInfo<>(articleMapper.findHottest());
    }

    @Override
    public PageInfo<DisplayArticle> findLatest(int pageNum) {
        PageHelper.startPage(pageNum, 5);
        return new PageInfo<>(articleMapper.findLatest());
    }
}
