package com.example.personalblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 权限
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

    @Id
    private int id;
    private int rid;
    private int uid;

    public Authority(int rid, int uid) {
        this.rid = rid;
        this.uid = uid;
    }
}
