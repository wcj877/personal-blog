package com.example.personalblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Admin {
    @RequestMapping("/admin/welcome")
    public String welcome(){
        return "/admin/welcome";
    }
    @RequestMapping("/admin/unicode")
    public String unicode(){
        return "/admin/unicode";
    }
}
