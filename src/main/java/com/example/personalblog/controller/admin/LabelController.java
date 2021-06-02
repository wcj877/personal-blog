package com.example.personalblog.controller.admin;

import com.example.personalblog.entity.Label;
import com.example.personalblog.service.LabelService;
import com.example.personalblog.vo.DisplayLabel;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
@RequestMapping("/admin")
public class LabelController {

    @Autowired
    LabelService labelService;

    @RequestMapping("/label/list")
    public String labelList(Integer pageNum, String str, Model model){
        if (str == null){
            str = "";
        }

        if (pageNum == null){
            pageNum = 1;
        }


        PageInfo<DisplayLabel> pageInfo = labelService.findAllLabel(pageNum, str);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("str",str);
        return "/admin/label-list";
    }

    @GetMapping("/label/add")
    public String getLabelAdd(){
        return "/admin/label-add";
    }

    @PostMapping("/label/add")
    @ResponseBody
    public void labelAdd(String name){
        labelService.saveLabel(new Label(name));
    }

    @GetMapping("/label/update/{id}")
    public String getUpdateLabel(@PathVariable int id, Model model){
        Label label = labelService.findByLid(id);
        model.addAttribute("label", label);
        return "/admin/label-update";
    }

    @PostMapping("/label/update")
    @ResponseBody
    public void updateLabel(int id, String name){
        labelService.updateLabel(id, name);
    }

    @PostMapping("/label/delete")
    @ResponseBody
    public void deleteLabel(int id){
        labelService.deleteById(id);
    }



}
