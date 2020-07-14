package com.ldf.easy.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * @author lidefu
 * @date 2020年07月13日10:59
 **/
public class JsonHelper {

    /**
     * to jsonString
     * @param o object
     * @return string
     */
    public static String toJsonString(Object o){
        Gson gson = new Gson();
        return gson.toJson(o);
    }

    /**
     * parse java object
     * @param src 源JSON字符串
     * @param des 目标对象
     * @param <T> -
     * @return Java Object
     */
    public static<T> T parse(String src, Class<T> des){
        Gson gson = new Gson();
        return gson.fromJson(src, des);
    }

    /**
     * parse Java Array
     * @param src 源JSON字符串
     * @param des 目标对象
     * @param <T> -
     * @return Java Object
     */
    public static<T> List<T> parseArray(String src, Class<T> des){
        Gson gson = new Gson();
        return gson.fromJson(src, new TypeToken<List<T>>() {}.getType());
    }

}
