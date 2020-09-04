package com.example.dsz.enums;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/7/30 9:36
 * @Description: 子账户类型
 */
public enum AccountType {
    GENERAL("GENERAL"),//普通
    ADMINISTRATOR("ADMINISTRATOR")//管理员
    ;
    private  String type;
    AccountType(String type){
           this.type = type;
    }
    public String getType() {
        return this.type;
    }
}
