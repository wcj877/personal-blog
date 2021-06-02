package com.example.personalblog.vo;

import com.example.personalblog.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisplayUser {
    private int id;
    private String headPortrait;
    private String userName;
    private String email;
    private String createTime;
    private String finallyTime;
    private Role role;
    private int state;
}
