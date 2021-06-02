package com.example.personalblog;

import com.example.personalblog.entity.ArticleLabel;
import com.example.personalblog.repository.ArticleLabelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ArticleLabelTest {

    @Autowired
    ArticleLabelRepository articleLabelRepository;

    @Test
    public void t1(){

        List<ArticleLabel> all = articleLabelRepository.findAll();
        for (ArticleLabel articleLabel : all) {
            System.out.println(articleLabel);
        }

    }

    @Test
    public void t2(){

        List<ArticleLabel> articleLabels = new ArrayList<>();
        articleLabels.add(ArticleLabel.builder().aid(2).lid(2).build());
        articleLabels.add(ArticleLabel.builder().aid(3).lid(2).build());
//        articleLabels.
        articleLabelRepository.saveAll(articleLabels);

    }

    @Test
    public void t3(){
        articleLabelRepository.deleteAllByAid(2);
    }

}
