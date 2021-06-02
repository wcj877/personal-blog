package com.example.personalblog.controller.admin;

import com.example.personalblog.entity.*;
import com.example.personalblog.service.*;
import com.example.personalblog.utils.DataTimeUtil;
import com.example.personalblog.vo.DisplayArticle;
import com.github.pagehelper.PageInfo;
import groovy.transform.ImmutableOptions;
import net.bytebuddy.asm.Advice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.security.auth.Subject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @Autowired
    LabelService labelService;

    @Autowired
    ClassifyService classifyService;

    @RequestMapping("/article/list")
    public String articleList(Integer pageNum, String str, Model model){
        if (str == null){
            str = "";
        }

        if (pageNum == null){
            pageNum = 1;
        }

        PageInfo<DisplayArticle> pageInfo = articleService.findAllArticle(pageNum, str);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("str",str);

        return "/admin/article-list";
    }

    @PostMapping("/article/updateState")
    @ResponseBody
    public void updateState(int id, int state){
        articleService.updateState(id, state);
    }

    @PostMapping("/article/delete")
    @ResponseBody
    public void delete(int id){
        articleService.deleteByAid(id);
    }

    @GetMapping("/article/add")
    public String getAdd(Model model){
        List<Label> labelList = labelService.findAll();
        List<Classify> classifyList = classifyService.findAll();

        model.addAttribute("labelList", labelList);
        model.addAttribute("classifyList", classifyList);

        return "/admin/article-add";
    }

    @PostMapping("/article/save")
    @ResponseBody
    public void saveArticle(Model model, Article article, int[] label){
        int length = label.length;
        for (int i = 0; i < label.length-1; i++) {
            System.out.println(label[i]);
        }

        article.setUpdateTime(DataTimeUtil.getDataTime());

//        String email = (String) SecurityUtils.getSubject().getPrincipal();//登录用户的邮箱

//        article.setUid(userService.findUser(email).getId());//获取创建文章的用户id

        //保存文章
        if (article.getAid() == 0){
            article.setCreateTime(DataTimeUtil.getDataTime());
            article.setWatchNumber(0);
            articleService.save(article, label);
        } else {
            //修改文章
            articleService.updateArticle(article, label);
        }
    }

    @GetMapping("/article/update/{id}")
    public String getUpdateArticle(Model model, @PathVariable("id") int id){
        List<Label> labelList = labelService.findAll();
        List<Classify> classifyList = classifyService.findAll();
        DisplayArticle article = articleService.findArticle(id);

        model.addAttribute("labelList", labelList);
        model.addAttribute("classifyList",classifyList);
        model.addAttribute("article", article);

        List<Integer> articleLabel = new ArrayList<>();
        List<Label> labels = article.getLabel();
        for (Label label : labels) {
            articleLabel.add(label.getLid());
        }

        model.addAttribute("articleLabel", articleLabel);

        return "/admin/article-update";
    }


    //保存图片
    @PostMapping("/article/img")
    @ResponseBody
    public Map<String, String> handleFile(@RequestParam("file") MultipartFile file){
        Map<String, String> result = new HashMap<>();

        if (file.isEmpty()){
            result.put("code", "1");
            result.put("msg", "文件为空");
        }

        String filename = file.getOriginalFilename();

        int size = (int) file.getSize();


        String path= ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/img";//获取项目classes/static的地址
        File dest = new File(path + "/" + filename);

        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest);//保存文件到dest目录下
            result.put("code", "0");
            result.put("msg", "上传成功");
            result.put("url","/img/"+filename);
        } catch (IllegalStateException e){
            e.printStackTrace();
            result.put("code","1");
            result.put("msg","上传失败");
        } catch (IOException e) {
            e.printStackTrace();
            result.put("code", "1");
            result.put("msg","上传失败");
        }

        return result;
    }







}
