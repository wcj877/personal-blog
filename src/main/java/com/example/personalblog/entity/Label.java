package com.example.personalblog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Label {
    @Id
    private int lid;
    private String labelName;

    public Label(String labelName) {
        this.labelName = labelName;
    }
}
