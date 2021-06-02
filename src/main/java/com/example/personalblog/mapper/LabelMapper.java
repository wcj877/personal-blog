package com.example.personalblog.mapper;

import com.example.personalblog.vo.DisplayLabel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LabelMapper {

    List<DisplayLabel> findAllLabel(@Param("str") String str);

}
