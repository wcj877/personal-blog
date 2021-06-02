package com.example.personalblog.mapper;

import com.example.personalblog.vo.DisplayClassify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassifyMapper {

    List<DisplayClassify> findAllClassify(@Param("str") String str);

}
