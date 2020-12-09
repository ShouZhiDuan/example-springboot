package com.example.dsz.model;

import javax.persistence.*;

@Table(name = "fudan_hpos")
public class FudanHpos {
    @Id
    private Integer id;

    /**
     * 表型名称
     */
    @Column(name = "hpo_name")
    private String hpoName;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取表型名称
     *
     * @return hpo_name - 表型名称
     */
    public String getHpoName() {
        return hpoName;
    }

    /**
     * 设置表型名称
     *
     * @param hpoName 表型名称
     */
    public void setHpoName(String hpoName) {
        this.hpoName = hpoName == null ? null : hpoName.trim();
    }
}