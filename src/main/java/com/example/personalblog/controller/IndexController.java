package com.example.personalblog.controller;

import com.example.personalblog.service.ArticleService;
import com.example.personalblog.vo.DisplayArticle;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;

    /**
     * 最热文章
     */
    @GetMapping("/")
    public void hottest(Model model){
        PageInfo<DisplayArticle> hottest = articleService.findHottest();


    }

    /**
     * 最新文章
     * @param model
     */
    @GetMapping("/latest")
    public void latest(Model model){

    }

}
