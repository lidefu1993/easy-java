package com.ldf.easy.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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
        System.out.println(result);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Demo{
        private Integer id;
        private String name;
    }

}
