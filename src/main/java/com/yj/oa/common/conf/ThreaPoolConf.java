package com.yj.oa.common.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 永健
 * 线程池
 */
@Configuration
public class ThreaPoolConf{
    /** 核心线程数*/
    private static final int  CORE_POOL_SIZE= 2;
    /** 最大线程数*/
    private static final int  MAX_NUM_POOL_SIZE= 10;
    /** 空闲时间*/
    private static final long  KEEPALL_LIVETIME= 60;


    @Bean
    public ThreadPoolExecutor threadPoolExecutor(
            @Qualifier("Handler") RejectedExecutionHandler rejectedExecutionHandler)
    {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_NUM_POOL_SIZE,
                KEEPALL_LIVETIME,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(50),
                rejectedExecutionHandler
        );

        return threadPoolExecutor;
    }

    /**
     * 线程池的拒绝策略：
     *
     * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
     * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
     * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
     */
    @Bean("Handler")
    public RejectedExecutionHandler rejectedExecutionHandler() {
        return new ThreadPoolExecutor.AbortPolicy();
    }
}
