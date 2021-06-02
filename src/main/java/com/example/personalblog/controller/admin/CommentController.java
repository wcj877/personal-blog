package com.example.personalblog.controller.admin;

import com.example.personalblog.entity.Comment;
import com.example.personalblog.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/comment/list")
    public String CommentList(Model model, Integer pageNum, String str){
        if (str == null){
            str = "";
        }

        if (pageNum == null){
            pageNum = 1;
        }

        PageInfo<Comment> pageInfo = commentService.findAllComment(pageNum, str);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("str",str);
        return "/admin/comment-list";
    }

    @PostMapping("/comment/updateState")
    @ResponseBody
    public void updateState(int id, int state){
        commentService.updateState(id, state);
    }



}
