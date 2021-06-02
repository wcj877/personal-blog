package com.example.personalblog.service.impl;

import com.example.personalblog.entity.Authority;
import com.example.personalblog.entity.Role;
import com.example.personalblog.entity.Users;
import com.example.personalblog.mapper.UsersMapper;
import com.example.personalblog.repository.AuthorityRepository;
import com.example.personalblog.repository.RoleRepository;
import com.example.personalblog.repository.UsersRepository;
import com.example.personalblog.service.UserService;
import com.example.personalblog.vo.DisplayUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UsersMapper usersMapper;


    @Override
    public Users saveUser(Users user) {
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), "blog", 1024);
        user.setPassword(md5Hash.toHex());

        Users save = usersRepository.save(user);
        //保存权限角色--用户
        Role role = roleRepository.getRoleByRoleName("user");
        authorityRepository.save(new Authority(role.getRid(), save.getId()));
        return save;
    }

    @Override
    public Users findUser(String email) {
        return usersRepository.findUser(email);
    }

    @Override
    public PageInfo<DisplayUser> findAllUser(int pageNum, String str) {
        PageHelper.startPage(pageNum,10);
        List<DisplayUser> userList = usersMapper.findAllUser(str);
        return new PageInfo<>(userList);
    }

    @Override
    public void updateState(int state, int id) {
        usersRepository.updateState(state, id);
    }


}
