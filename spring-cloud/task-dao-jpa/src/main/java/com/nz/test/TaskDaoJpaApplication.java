package com.nz.test;

import com.nz.test.service.impl.AsyncTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.UUID;
import java.util.concurrent.Future;

@EnableAsync
@EnableDiscoveryClient
@SpringBootApplication
public class TaskDaoJpaApplication {

    @Autowired
    private AsyncTaskServiceImpl asyncTaskService;

    public static void main(String[] args) {
        SpringApplication.run(TaskDaoJpaApplication.class, args);
    }

	/**
	 * 执行时机为容器启动完成: CommandLineRunner、ApplicationRunner
	 * @return
	 */
	@Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
            long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
            //无返回值
            asyncTaskService.asyncTask();
            //有返回值,但主线程不需要用到返回值
            asyncTaskService.asyncTask(UUID.randomUUID().toString());
            //有返回值,且主线程需要用到返回值
			Future<String> future = asyncTaskService.asyncTask(UUID.randomUUID().toString());
            System.out.println(Thread.currentThread().getName() + "：返回值：" + future.get());
            //事务测试,事务正常提交
            asyncTaskService.asyncTaskForTransaction(false);
            //事务测试,模拟异常事务回滚
            asyncTaskService.asyncTaskForTransaction(true);
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "：调用异步业务结束,耗时：" + (endTime - startTime));
        };
    }
}
