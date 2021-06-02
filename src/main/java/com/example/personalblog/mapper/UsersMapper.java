package com.example.personalblog.mapper;

import com.example.personalblog.entity.Users;
import com.example.personalblog.vo.DisplayUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsersMapper {

    List<DisplayUser> findAllUser(@Param("str") String str);

}
