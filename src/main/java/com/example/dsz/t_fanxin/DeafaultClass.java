package com.example.dsz.t_fanxin;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/8 11:08
 * @Description: DeafaultClass默认修饰符只能在本包中使用
 */
@Data
class DeafaultClass {
    private int age;

    @Data
    class JsonData {
        private int age;
        private String name;
    }

    public static void main(String[] args) {
        String data = "{\"age\":10,\"name\":\"dsz\"}";
        JsonData jsonData = JSON.parseObject(data, DeafaultClass.JsonData.class);
        System.out.println("");

        JsonData jsonData1 = new DeafaultClass().new JsonData();

    }


}
