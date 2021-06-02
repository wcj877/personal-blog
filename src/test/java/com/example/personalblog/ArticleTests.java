package com.example.personalblog;

import com.example.personalblog.mapper.ArticleMapper;
import com.example.personalblog.vo.DisplayArticle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ArticleTests {

    @Autowired
    ArticleMapper articleMapper;

//    @Test
//    void test1(){
//        List<DisplayArticle> allArticle = articleMapper.findAllArticle();
//        for (DisplayArticle displayArticle : allArticle) {
//            System.out.println(displayArticle);
//        }
//    }

}
