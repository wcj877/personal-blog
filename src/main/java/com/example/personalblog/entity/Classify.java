package com.example.personalblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Classify {

    @Id
    private int clid;
    private String className;

    public Classify(String className) {
        this.className = className;
    }
}
