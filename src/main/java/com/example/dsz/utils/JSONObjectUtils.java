package com.example.dsz.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/8/20 13:18
 * @Description:对象序列化工具
 */
public class JSONObjectUtils {

    private  static  final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将json结果集转化为对象
     * @param jsonData json数据
     * @return
     */
    public static <T> T jsonToObject(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
