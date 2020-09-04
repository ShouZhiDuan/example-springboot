package com.example.dsz.test;

import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/8/20 14:41
 * @Description:
 */
@Data
public class Organization {
    //机构名称
    private String name;
    //机构代码
    private String code;
    //机构联系人
    private String linkman;
    //机构联系电话
    private String phone;
    //机构所属国家、可为空
    private String country;
    //机构所属省
    private String province;
    //机构所属市
    private String city;
    //机构所属区
    private String area;
    //机构所属详细地址
    private String address;
}
