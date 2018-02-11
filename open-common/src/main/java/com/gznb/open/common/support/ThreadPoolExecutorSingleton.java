package com.gznb.open.common.support;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池单例
 *
 * Created by jj02 on 2016/12/29.
 */
public class ThreadPoolExecutorSingleton {

    private static ThreadPoolExecutor instance = null;

    private ThreadPoolExecutorSingleton(){

    }

    public static ThreadPoolExecutor getInstance(){
        if(instance == null){
            initExecutor();
        }
        return instance;
    }

    /**
     * 线程池初始化
     *
     * 初始化参数查看ThreadPoolExecutorTest类
     */
    private static synchronized void initExecutor() {
        if(instance == null){
            instance = new ThreadPoolExecutor(10,30,1,
                    TimeUnit.SECONDS,new LinkedBlockingQueue<>(20));
            instance.allowCoreThreadTimeOut(true);
        }
    }

}
