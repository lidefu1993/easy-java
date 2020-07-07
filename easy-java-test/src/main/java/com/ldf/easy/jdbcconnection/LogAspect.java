package com.ldf.easy.jdbcconnection;
import com.ldf.easy.mybatis.TestMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author lidefu
 * @date 2020年03月26日14:14
 **/
@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private TestMapper testMapper;

    @Pointcut("execution(public * com.ldf.easy.jdbcconnection.JdbcConnectionPressureController.*(..))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        Object result = null;
        //异常标识 0没有异常 1存在异常
        int exceptionFlag = 0;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            exceptionFlag = 1;
            throw e;
        }finally {
            // 执行时长(毫秒)
            long time = System.currentTimeMillis() - beginTime;
            saveLog();
        }


        return result;
    }

    private void saveLog(){
        try{
            System.out.println("insert------------------");
            testMapper.insertLog(UUID.randomUUID().toString());
        }catch (Exception e){
            LOGGER.error("记录操作日志异常", e);
        }
    }

}
