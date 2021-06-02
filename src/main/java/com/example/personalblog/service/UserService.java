package com.example.personalblog.service;

import com.example.personalblog.entity.Users;
import com.example.personalblog.vo.DisplayUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    /**
     * 注册用户
     * 并自动保存为用户角色
     * @param user
     */
    Users saveUser(Users user);

    //获取用户
    Users findUser(String email);

    /**
     * 查询所有用户
     * @param pageNum 页数
     * @param str 模糊查询参数
     * @return
     */
    PageInfo<DisplayUser> findAllUser(int pageNum, String str);

    //修改用户状态
    void updateState(int state, int id);



}
