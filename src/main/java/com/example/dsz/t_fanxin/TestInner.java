package com.example.dsz.t_fanxin;

import lombok.Data;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/8 10:43
 * @Description:
 */
@Data
public class TestInner {

    private int age=10;

    class Inner{
        private int age=20;
        private void testDo(){
            int age = 30;
            System.out.println(age);
            System.out.println(this.age);
            System.out.println(TestInner.this.age);
        }
    }

    public static void main(String[] args) {
        TestInner.Inner inner = new TestInner().new Inner();
        inner.testDo();
    }



}
