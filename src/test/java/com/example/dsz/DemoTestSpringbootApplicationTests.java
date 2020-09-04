package com.example.dsz;

import com.example.dsz.utils.JsonObjectUtils;
import lombok.Data;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

//@SpringBootTest
 class DemoTestSpringbootApplicationTests {

    @Data
    public  class Organization {
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

    @Test
    void doTest() throws JSONException {
 /*       Organization organization = new Organization();
        organization.setName("机构名称");
        organization.setCode("机构代码");
        organization.setLinkman("联系人");
        organization.setPhone("联系电话");
        organization.setCountry("所在国家");
        organization.setProvince("所在省份");
        organization.setCity("所在城市");
        organization.setArea("所在区");
        organization.setAddress("详细地址：街道、门牌");
        System.out.println(JSON.toJSONString(organization));*/
        DemoTestSpringbootApplicationTests applicationTests = new DemoTestSpringbootApplicationTests();
        String tx = "{\"address\":\"详细地址：街道、门牌\",\"area\":\"所在区\",\"city\":\"所在城市\",\"code\":\"机构代码\",\"country\":\"所在国家\",\"linkman\":\"联系人\",\"name\":\"机构名称\",\"phone\":\"联系电话\",\"province\":\"所在省份\"}";
        Organization organization = JsonObjectUtils.jsonToObject(tx, Organization.class);
        System.out.println();






    }

}
