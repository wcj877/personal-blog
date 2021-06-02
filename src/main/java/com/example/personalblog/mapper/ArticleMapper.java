package com.example.personalblog.mapper;

import com.example.personalblog.vo.DisplayArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

    /**
     * 查询所有文章
     * @return
     */
    List<DisplayArticle> findAllArticle(@Param("str")String str);

    /**
     * 指定id查询文章
     * @param id
     * @return
     */
    DisplayArticle findArticle(@Param("id") int id);

    /**
     * 查询最热文章
     * @return
     */
    List<DisplayArticle> findHottest();

    /**
     * 查询最新的文章
     */
    List<DisplayArticle> findLatest();

}
