package com.example.dsz.md5;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/9/24 10:42
 * @Description:
 */
public class MD5Test {

    private int a = 10;

    @Test//注意junit单元测试不用有含参构造方法
    public void test1() {
        String key = "Jn1VDL0efxGo"; //平台约定秘钥
        String timestamp = "1600918286000"; //13位当前时间戳
        String barcode = "TEST1234567890"; //套件码14位
        String info = key + timestamp + barcode;
        String sign = DigestUtils.md5Hex(info);  //696f315dc8340af9
        System.out.println(sign.substring(8, sign.length() - 8));//32位
    }

    public MD5Test() {
    }

    public static void main(String[] args) {
        boolean flag = true;
        do {
            System.out.println(flag);
        } while (flag);
    }


}
