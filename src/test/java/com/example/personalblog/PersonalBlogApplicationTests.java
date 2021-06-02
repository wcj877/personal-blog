package com.example.personalblog;

import com.example.personalblog.entity.Authority;
import com.example.personalblog.entity.Label;
import com.example.personalblog.entity.Users;
import com.example.personalblog.mapper.UsersMapper;
import com.example.personalblog.repository.AuthorityRepository;
import com.example.personalblog.repository.LabelRepository;
import com.example.personalblog.repository.UsersRepository;
import com.example.personalblog.vo.DisplayUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import groovy.transform.AutoExternalize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PersonalBlogApplicationTests {

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UsersMapper usersMapper;

    @Test
    void contextLoads() {
        List<Label> all = labelRepository.findAll();
        for (Label label : all) {
            System.out.println(label);
        }
    }

//    @Test
//    void userTest(){
//        PageHelper.startPage(1,1);
//        List<DisplayUser> allUser = usersMapper.findAllUser();
//        PageInfo<DisplayUser> pageInfo = new PageInfo<>(allUser);
//        System.out.println(pageInfo);
//
//    }

    @Test
    void finUserTest(){
        Users user = usersRepository.findUser("1");
        System.out.println(user);
    }

    @Test
    void finAuthority(){

        List<Authority> all = authorityRepository.findAllByEmail("1");
//        List<Authority> all = authorityRepository.findAll();
        for (Authority authority : all) {
            System.out.println(authority);
        }
    }


//    @Test
//    void findStr(){
//        List<DisplayUser> byEmailLike = usersMapper.findByEmailLike("123");
//        for (DisplayUser displayUser : byEmailLike) {
//            System.out.println(displayUser);
//        }
//    }
}
