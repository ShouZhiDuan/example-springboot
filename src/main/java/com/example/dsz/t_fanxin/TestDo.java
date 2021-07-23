package com.example.dsz.t_fanxin;

import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/8 10:16
 * @Description:
 */
@Data
public class TestDo {

    protected int age;

    private void test() {
        Ttest1 ttest1 = new Ttest1();
        Ttest1.Animals animals = new Ttest1.Animals();
    }


}
