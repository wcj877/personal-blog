package com.example.personalblog.controller.admin;

import com.example.personalblog.entity.Classify;
import com.example.personalblog.service.ClassifyService;
import com.example.personalblog.vo.DisplayClassify;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ClassifyController {

    @Autowired
    ClassifyService classifyService;

    @RequestMapping("/classify/list")
    public String classifyList(Integer pageNum, String str, Model model){

        if (str == null){
            str = "";
        }

        if (pageNum == null){
            pageNum = 1;
        }

        PageInfo<DisplayClassify> pageInfo = classifyService.findAllClassify(pageNum, str);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("str",str);

        return "/admin/classify-list";
    }

    @GetMapping("/classify/add")
    public String getClassifyAdd(){
        return "/admin/classify-add";
    }

    @PostMapping("/classify/add")
    @ResponseBody
    public void classifyAdd(String name){
        classifyService.saveClassify(new Classify(name));
    }

    @PostMapping("/classify/delete")
    @ResponseBody
    public void deleteClassify(int id){
        classifyService.deleteClassify(id);
    }

    @GetMapping("/classify/update/{id}")
    public String getClassifyUpdate(@PathVariable("id") int id, Model model){
        Classify classify = classifyService.findClassify(id);
        model.addAttribute("classify", classify);
        return "/admin/classify-update";
    }

    @PostMapping("/classify/update")
    @ResponseBody
    public void classifyUpdate(int id, String name){
        classifyService.update(name, id);
    }


}
