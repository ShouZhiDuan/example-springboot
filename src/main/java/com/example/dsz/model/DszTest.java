package com.example.dsz.model;

import com.example.dsz.mybatis.type_handler.StatusHandler;
import com.example.dsz.mybatis.type_handler.UserStatus;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;

@Table(name = "dsz_test")
public class DszTest {
    @Id
    private Integer id;

    private String name;

    private Integer age;

    private String addr;

    private String tes;
    @ColumnType(jdbcType = JdbcType.INTEGER,typeHandler = StatusHandler.class)
    private UserStatus status;

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

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * @param addr
     */
    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    /**
     * @return tes
     */
    public String getTes() {
        return tes;
    }

    /**
     * @param tes
     */
    public void setTes(String tes) {
        this.tes = tes == null ? null : tes.trim();
    }

    /**
     * @return status
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(UserStatus status) {
        this.status = status;
    }
}