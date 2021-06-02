package com.example.personalblog.controller.admin;

import com.example.personalblog.service.UserService;
import com.example.personalblog.vo.DisplayUser;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.function.DoubleToIntFunction;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户列表
     * @return
     */
    @RequestMapping("/admin/user/list")
    public String member(Integer pageNum,String str, Model model){
        if (str == null){
            str = "";
        }

        if (pageNum == null){
            pageNum = 1;
        }

        PageInfo<DisplayUser> pageInfo = userService.findAllUser(pageNum, str);
        System.out.println(str);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("str",str);
        return "/admin/user-list";
    }


    @GetMapping("/admin/user/welcome")
    public String userWelcome(){
        return "/admin/user-welcome";
    }

    @PostMapping("/admin/user/updateState")
    @ResponseBody
    public void updateState(int state,int id){
        userService.updateState(state, id);
    }
}
