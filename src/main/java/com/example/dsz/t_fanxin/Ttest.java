package com.example.dsz.t_fanxin;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/8 9:45
 * @Description:
 */
@Data
public class Ttest<T> {

    private T note;

    public static void main(String[] args) {
        //编译的时候就明确类型，防止编译漏洞
        Ttest<String> ttest = new Ttest();
        ttest.setNote("test");
        System.out.println(JSON.toJSONString(ttest));
    }


}
