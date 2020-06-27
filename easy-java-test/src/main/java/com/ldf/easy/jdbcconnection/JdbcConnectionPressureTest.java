package com.ldf.easy.jdbcconnection;

import com.alibaba.druid.pool.DruidDataSource;
import com.ldf.easy.TestApp;
import com.ldf.easy.mybatis.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author ldf
 * @date 2020/6/20 15:45
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApp.class)
public class JdbcConnectionPressureTest {

    @Autowired
    private TestMapper testMapper;
    @Autowired
    private DruidDataSource dataSource;

    int num = 0;

    @Test
    public void test() throws InterruptedException {
        int threadNum = 4000;

        for(int i=0; i<threadNum; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    query();
                    System.out.println("-------------------");
                    insert();
                }
            }).start();
        }
        Thread.currentThread().join();
        System.out.println("end----------");
    }

    @Test
    public void test1() throws InterruptedException {
        int requestTotal = 1000;
        int concurrentThreadNum = 20;
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        Semaphore semaphore = new Semaphore(concurrentThreadNum);
//        for (int i = 0; i< requestTotal; i++) {
//            executorService.execute(()->{
//                try {
//                    semaphore.acquire();
//                    query();
//                    semaphore.release();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//            });
//        }
        for (int i = 0; i< requestTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    insert();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("请求完成");
    }

    @Test
    public void test2() throws InterruptedException {
        for(int i=0; i<12; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    query();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    insert();
                }
            }).start();
            dataSource.close();
        }
        Thread.currentThread().join();
    }

    private void query(){
        System.out.println("query------------begin-" + (num++));
        testMapper.selectCounty();
        System.out.println("query-------------------end");
    }

    @Test
    public void insert(){
        System.out.println("insert------------------begin");
        testMapper.insertLog(UUID.randomUUID().toString());
        System.out.println("insert----------------end");
    }

//    private void test1(){
//        int threadNum = 200;
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 100, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1000), Executors.defaultThreadFactory());
//        for(int i=0; i<threadNum; i++){
//            executor.submit(new Runnable() {
//                @Override
//                public void run() {
//                    query();
//                    try {
////                        Thread.sleep(1000L);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    insert();
//                }
//            });
//        }
//    }

}
