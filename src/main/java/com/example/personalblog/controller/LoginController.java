package com.example.personalblog.controller;

import com.example.personalblog.entity.Users;
import com.example.personalblog.service.UserService;
import com.example.personalblog.service.impl.UserServiceImpl;
import com.example.personalblog.utils.VerifyCodeUtil;
import com.example.personalblog.vo.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/login")
    public String getLogin(){
        return "/login";
    }

    //登录
    @PostMapping("/login")
    public String login(LoginUser user, String remember , HttpServletRequest request, Model model){
        Subject subject = SecurityUtils.getSubject();
        String verifyCode = (String) request.getSession().getAttribute(VerifyCodeUtil.RANDOMCODEKEY);


        verifyCode = verifyCode.toLowerCase();

        if (!verifyCode.equals(user.getVerify().toLowerCase())){
            model.addAttribute("msg", "验证码错误");
            model.addAttribute("user",user);
            return "login";
        }

        boolean rememberMe = false;
        if (!Objects.isNull(remember)){
            rememberMe = true;
        }

        UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(),user.getPassword(),rememberMe);
        try {
            subject.login(token);
            return "logon";
        } catch (Exception e){
            model.addAttribute("msg", "邮箱或者密码错误");
            model.addAttribute("user",user);
            return "login";
        }
    }

    @GetMapping("/logon")
    public String getLogon(){
        return "/logon";
    }

    /**
     * 注册
     * @param user
     * @param model
     * @return
     */
    @PostMapping("/logon")
    public String logon(LoginUser user, Model model){
        if (!Objects.isNull(userService.findUser(user.getEmail()))){
            model.addAttribute("msg", "该邮箱已注册");
            model.addAttribute("user",user);
            return "logon";
        }

        Users users = userService.saveUser(new Users(user.getPassword(), user.getEmail()));

        return "login";
    }

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();
        String verify = verifyCodeUtil.getRandcode(request, response);//输出验证码图片方法

        model.addAttribute("verify",verify);
        System.out.println(verify);

        System.out.println("更换验证码");
    }


}
