package com.example.dsz.mybatis.type_handler;


import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2021/3/12 17:25
 * @Description:
 */
public enum UserStatus {

    one(1,"录入中"),
    two(2,"录入完成");

    @Getter @Setter
    private int code;
    @Getter @Setter
    private String msg;

    UserStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
