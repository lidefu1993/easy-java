package com.ldf.easy.jdbcconnection;
import com.ldf.easy.mybatis.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ldf
 * @date 2020/6/20 20:53
 **/
@RestController
@RequestMapping("jp")
public class JdbcConnectionPressureController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("qy")
    public Object qy() throws InterruptedException {
//        Thread.sleep(1000*6);
        System.out.println("query------------");
        return testMapper.selectCounty();
    }

}
