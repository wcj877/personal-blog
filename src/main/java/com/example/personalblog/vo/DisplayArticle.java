package com.example.personalblog.vo;

import com.example.personalblog.entity.Classify;
import com.example.personalblog.entity.Label;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisplayArticle {

    private int id;
    private int uid;
    private String headine;
    private String createTime;
    private String updateTime;
    private String content;
    private int watchNumber;
    private String coverPhoto;
    private int state;
    private List<Label> label;
    private Classify classify;

}
