package com.example.dsz.web_magic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class ParamUtils {
    private static final Logger logger = LoggerFactory.getLogger(ParamUtils.class);

    public static JSONObject stringToJSONObject(String param){
        JSONObject ret = null;
        try{
            if(param != null && param.length()>0){
                JSONObject jsonObject = JSON.parseObject(param);
                if(jsonObject != null && !jsonObject.isEmpty()){
                    ret = jsonObject;
                }
            }
        }catch (Exception e){
            String error = e.getMessage();
            logger.error(error);
        }
        return ret;
    }

    public static String jsonobjectToString(JSONObject jsonObject){
        if(jsonObject != null && !jsonObject.isEmpty()){
            return jsonObject.toString();
        }
        return  null;
    }

    public static Object stringToObject(String str){
        Object ret = null;
        try{
            Object tmp = JSON.parseObject(str);
            if(tmp != null){
                ret = tmp;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return ret;
    }

    public static String objectToString(Object obj){
        String ret = null;
        try{
            String tmp = JSON.toJSONString(obj);
            if(tmp != null){
                ret = tmp;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return ret;
    }
}
