package com.example.personalblog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleLabel implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //IDENTITY：主键由数据库自动生成（主要是自动增长型）
    private int alid;
    private int lid;
    private int aid;


    public ArticleLabel(int lid, int aid) {
        this.lid = lid;
        this.aid = aid;
    }
}
