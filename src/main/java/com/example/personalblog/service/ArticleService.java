package com.example.personalblog.service;

import com.example.personalblog.entity.Article;
import com.example.personalblog.vo.DisplayArticle;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ArticleService {

    PageInfo<DisplayArticle> findAllArticle(int pageNum, String str);

    DisplayArticle findArticle(int id);

    void updateState(int id, int state);

    void deleteByAid(int id);

    void save(Article article , int[] label);

    void updateArticle(Article article, int[] label);

    /**
     * 最热的4篇文章
     * @return
     */
    PageInfo<DisplayArticle> findHottest();

    /**
     * 最新的文章
     * @return
     */
    PageInfo<DisplayArticle> findLatest(int pageNum);
}
