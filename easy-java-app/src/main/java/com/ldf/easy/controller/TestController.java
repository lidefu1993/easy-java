package com.ldf.easy.controller;

import com.ldf.easy.domain.vo.TestVO;
import com.ldf.easy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lidefu
 * @date 2020年08月10日11:32
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("jackson")
    public TestVO jackson(){
        return testService.test();
    }

}
