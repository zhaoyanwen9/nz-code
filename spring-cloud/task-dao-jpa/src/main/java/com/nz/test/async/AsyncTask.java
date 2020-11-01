package com.nz.test.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async
public class AsyncTask {

    public void task1() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("当前线程：" + Thread.currentThread().getName() + "，" + "任务一耗时：" + (end - start) + "ms");
    }

    public void task2() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("当前线程：" + Thread.currentThread().getName()  + "，" + "任务二耗时：" + (end - start) + "ms");
    }

    public void task3() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("当前线程：" + Thread.currentThread().getName() + "，" + "任务三耗时：" + (end - start) + "ms");
    }
}
