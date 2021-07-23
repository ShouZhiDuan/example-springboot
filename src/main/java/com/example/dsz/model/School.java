package com.example.dsz.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "school")
public class School {
    @Id
    private Integer id;
    @Column(name = "school_name")
    private String schoolName;
}