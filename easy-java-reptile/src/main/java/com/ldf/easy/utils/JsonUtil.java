package com.ldf.easy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author lidefu
 * @date 2020年07月24日14:59
 **/
public class JsonUtil {

    public static String toJsonString(Object obj){
        return JSON.toJSONString(obj);
    }

    public static<T> T parse(Object obj, Class<T> tClass){
        return (obj instanceof String) ? JSONObject.parseObject((String) obj, tClass) : JSONObject.parseObject(toJsonString(obj) , tClass);
    }

    public static <T> List<T> parseArray(Object obj, Class<T> tClass){
        return (obj instanceof String) ? JSON.parseArray((String) obj, tClass) : JSON.parseArray(toJsonString(obj), tClass);
    }

}
