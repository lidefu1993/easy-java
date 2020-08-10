package com.ldf.easy.service.impl;

import com.ldf.easy.domain.vo.TestVO;
import com.ldf.easy.service.TestService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lidefu
 * @date 2020年08月10日11:31
 **/
@Service
public class TestServiceVO implements TestService {

    @Override
    public TestVO test() {
        TestVO testVO = new TestVO();
        testVO.setId(1);
        testVO.setAge(20);
        testVO.setBirth(new Date());
        testVO.setCreateDt(new Date());
        return testVO;
    }

}
