package com.example.personalblog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisplayClassify {

    private int id;
    private String name;
    private int countNumber;//文章数量
}
