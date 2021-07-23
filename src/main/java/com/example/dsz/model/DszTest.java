package com.example.dsz.model;

import com.example.dsz.mybatis.type_handler.StatusHandler;
import com.example.dsz.mybatis.type_handler.UserStatus;
import lombok.Data;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "dsz_test")
public class DszTest {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private Integer age;

    private String addr;

    private String tes;

    @ColumnType(typeHandler = StatusHandler.class)
    private UserStatus status;

    @Column(name = "school_id")
    private Integer schoolId;
}