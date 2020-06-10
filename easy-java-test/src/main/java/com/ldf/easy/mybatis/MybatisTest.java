package com.ldf.easy.mybatis;

import com.ldf.easy.TestApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lidefu
 * @date 2020年06月09日20:39
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApp.class)
public class MybatisTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void test1(){
        List<MybatisTestDO> dos = testMapper.selectList(1);
        System.out.println(dos);
        assert dos.size() == 1;
    }


}
