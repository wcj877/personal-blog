package com.example.personalblog.repository;

import com.example.personalblog.entity.ArticleLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleLabelRepository extends JpaRepository<ArticleLabel, Integer> {

    @Transactional
    @Modifying
    void deleteAllByAid(int aid);

}
