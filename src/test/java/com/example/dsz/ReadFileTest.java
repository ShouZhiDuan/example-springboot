package com.example.dsz;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/10/20 20:18
 * @Description:
 */
public class ReadFileTest {

    @Test
    public void  readFile() throws IOException {
        //当前项目下路径
        File file = new File("");
        String filePath = file.getCanonicalPath();
        System.out.println("当前项目下路径：" + filePath);
        //获取类加载的根路径
        File file2 = new File(this.getClass().getResource("/").getPath());
        System.out.println("获取类加载的根路径：" + file2);
        //获取所有的类路径 包括jar包的路径
        System.out.println(System.getProperty("java.class.path"));
    }


    @Test
    public void test2(){
        Byte by = 0;
        System.out.println(by==0);
    }


}
