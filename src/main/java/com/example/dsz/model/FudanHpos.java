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
     * 英文名称
     */
    @Column(name = "name_en")
    private String nameEn;

    /**
     * 英文描述
     */
    @Column(name = "definition_en")
    private String definitionEn;

    /**
     * 中文名称
     */
    @Column(name = "name_zh")
    private String nameZh;

    /**
     * 中文描述
     */
    @Column(name = "definition_zh")
    private String definitionZh;

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

    /**
     * 获取英文名称
     *
     * @return name_en - 英文名称
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * 设置英文名称
     *
     * @param nameEn 英文名称
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    /**
     * 获取英文描述
     *
     * @return definition_en - 英文描述
     */
    public String getDefinitionEn() {
        return definitionEn;
    }

    /**
     * 设置英文描述
     *
     * @param definitionEn 英文描述
     */
    public void setDefinitionEn(String definitionEn) {
        this.definitionEn = definitionEn == null ? null : definitionEn.trim();
    }

    /**
     * 获取中文名称
     *
     * @return name_zh - 中文名称
     */
    public String getNameZh() {
        return nameZh;
    }

    /**
     * 设置中文名称
     *
     * @param nameZh 中文名称
     */
    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    /**
     * 获取中文描述
     *
     * @return definition_zh - 中文描述
     */
    public String getDefinitionZh() {
        return definitionZh;
    }

    /**
     * 设置中文描述
     *
     * @param definitionZh 中文描述
     */
    public void setDefinitionZh(String definitionZh) {
        this.definitionZh = definitionZh == null ? null : definitionZh.trim();
    }
}