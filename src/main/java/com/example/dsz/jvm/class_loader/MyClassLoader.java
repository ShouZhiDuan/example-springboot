package com.example.dsz.jvm.class_loader;

import lombok.Data;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/10 14:44
 * @Description:
 */
@Data
public class MyClassLoader extends ClassLoader {

    private String root;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试
     */
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader();
        myClassLoader.setRoot("E:\\temp");
        Class<?> aClass = myClassLoader.loadClass("test_pack.TestLoader");
        Method testDo = aClass.getMethod("main", String[].class);
        //注意这里调用main函数传入的string[]参数要转换成一个整体，否则会当期做多个参数拆开传入，出现wrong number of arguments
        testDo.invoke(null, (Object) new String[]{"123", "456"});
        System.out.println();
    }


}