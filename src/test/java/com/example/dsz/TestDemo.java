package com.example.dsz;

import com.example.dsz.enums.AccountType;
import org.junit.Test;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/10/10 17:48
 * @Description:
 */
public class TestDemo {
    @Test
    public void test1() {
        System.out.println(System.currentTimeMillis() + 10 * 60 * 1000);
    }

    @Test
    public void test2() {
        System.out.println(AccountType.valueOf("GENERAL").getType());
    }
}
