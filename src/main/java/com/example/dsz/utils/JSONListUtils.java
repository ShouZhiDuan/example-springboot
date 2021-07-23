package com.example.dsz.utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/10/21 9:23
 * @Description: 字符串转List
 */
public class JSONListUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 字符串转List
     */
    public static <T> T stringToList(String jsonStr, Class<T> beanType) throws IOException {
        // return MAPPER.readValue(jsonStr,new TypeReference<List<beanType>>(){});
        return null;
    }

    public static void main(String[] args) {
        Class jsonListUtilsClass = JSONListUtils.class;
        Class jsonListUtilsClass2 = JSONListUtils.class;
        System.out.println(jsonListUtilsClass);
        System.out.println(jsonListUtilsClass2);
        System.out.println(jsonListUtilsClass.equals(jsonListUtilsClass2));
    }


}
