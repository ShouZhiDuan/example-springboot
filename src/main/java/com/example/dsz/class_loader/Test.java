package com.example.dsz.class_loader;

import com.example.dsz.DemoTestSpringbootApplication;

import java.io.File;
import java.net.URL;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/7/21 22:15
 * @Description:
 */
public class Test {

//    @org.junit.Test
//    public  void testDo() {
//        URL url = this.getClass().getClassLoader().getResource("/com/example/dsz");
//        System.out.println(url);
//    }

    public static void main(String[] args) {
        Test test = new Test();
        URL url =
                //test.getClass().getClassLoader().getResource("com/example/dsz/class_loader");
                //Test.class.getClassLoader().getResource("com/example/dsz/class_loader");
                //Test.class.getResource(""); //file:/E:/git-workspace-test/demo-test-springboot/target/classes/com/example/dsz/class_loader/
                //Test.class.getResource("/");//file:/E:/git-workspace-test/demo-test-springboot/target/classes/
                //DemoTestSpringbootApplication.class.getResource("/");//file:/E:/git-workspace-test/demo-test-springboot/target/classes/
                DemoTestSpringbootApplication.class.getResource("");
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            System.out.println("文件名 = " + file.getName());
        }
        System.out.println(url);
    }


}
