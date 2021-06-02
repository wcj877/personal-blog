package com.example.personalblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //IDENTITY：主键由数据库自动生成（主要是自动增长型）
    private int id;
    private String email;
    private String username;
    private String password;
    //头像
    private String headPortrait;
    //用户创建时间
    private String CreateTime;
    //用户最近登录时间
    private String finallyTime;
    //状态
    private int state;
    //签名
    private String signature;

    public Users(String password, String email) {
        this.password = password;
        this.email = email;
    }
}
