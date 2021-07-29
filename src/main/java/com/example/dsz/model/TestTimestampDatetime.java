package com.example.dsz.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "test_timestamp_datetime")
public class TestTimestampDatetime {
    @Id
    private Integer id;

    private Date created;

    private Date updated;

    @Column(name = "updated_1")
    private Date updated1;

    @Column(name = "updated_2")
    private Date updated2;

    private String name;

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
     * @return created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return updated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * @return updated_1
     */
    public Date getUpdated1() {
        return updated1;
    }

    /**
     * @param updated1
     */
    public void setUpdated1(Date updated1) {
        this.updated1 = updated1;
    }

    /**
     * @return updated_2
     */
    public Date getUpdated2() {
        return updated2;
    }

    /**
     * @param updated2
     */
    public void setUpdated2(Date updated2) {
        this.updated2 = updated2;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}