package com.example.dsz.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class School2 {
    private Integer schoolId;
    private String schoolName;
}