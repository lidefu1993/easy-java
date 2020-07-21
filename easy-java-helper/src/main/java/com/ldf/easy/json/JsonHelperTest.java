package com.ldf.easy.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @author lidefu
 * @date 2020年07月13日11:01
 **/
@RunWith(SpringRunner.class)
public class JsonHelperTest {

    @Test
    public void toJsonStringSingle(){
        Demo demo = new Demo(1, "ldf");
        String s = JsonHelper.toJsonString(demo);
        System.out.println(s);
    }

    @Test
    public void toJsonStringList(){
        List<Demo> list = Arrays.asList(new Demo(1, "ldf"), new Demo(2, "lq"));
        String s = JsonHelper.toJsonString(list);
        System.out.println(s);
    }

    @Test
    public void parse(){
        Demo demo = new Demo(1, "ldf");
        String s = JsonHelper.toJsonString(demo);
        Demo result = JsonHelper.parse(s, Demo.class);
        System.out.println(result);
    }

    @Test
    public void parseArray(){
        List<Demo> list = Arrays.asList(new Demo(1, "ldf"), new Demo(2, "lq"));
        String s = JsonHelper.toJsonString(list);
        List<Demo> result = JsonHelper.parseArray(s, Demo.class);
        Demo demo = result.get(0);
        System.out.println(result);
    }

    @Test
    public void parseArray2(){
        List<Demo> list = Arrays.asList(new Demo(1, "ldf"), new Demo(2, "lq"));
        String s = JsonHelper.toJsonString(list);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Demo>>() {}.getType();
        List<Demo> list1 = gson.fromJson(s, type);
        Demo demo = list1.get(0);
        System.out.println(list1);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Demo{
        private Integer id;
        private String name;
    }

}
