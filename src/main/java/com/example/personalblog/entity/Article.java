package com.example.personalblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //IDENTITY：主键由数据库自动生成（主要是自动增长型）
    private int aid;
    private String headine;
    private String content;
    private String updateTime;
    private String createTime;
    private String coverPhoto;
    private int watchNumber;
    private int state;
    private int clid;
    private int uid;
}
