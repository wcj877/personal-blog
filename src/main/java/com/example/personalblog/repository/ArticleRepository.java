package com.example.personalblog.repository;

import com.example.personalblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Article where aid=:aid")
    void deleteByAid(@Param("aid") int aid);

    @Modifying
    @Transactional
    @Query("update Article set state=:state where aid=:aid")
    void updateState(@Param("aid") int aid,@Param("state") int state);

    @Modifying
    @Transactional
    @Query("update Article set headine=:headine,content=:content," +
            " updateTime=:updateTime, coverPhoto=:coverPhoto, state=:state,clid=:clid where aid=:aid")
    void updateArticle(@Param("aid")int aid,@Param("headine")String headine, @Param("content")String content,@Param("updateTime")String updateTime,
                       @Param("coverPhoto")String coverPhoto, @Param("state") int state, @Param("clid")int clid);
}
