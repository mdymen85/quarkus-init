package org.init;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class ThreadPoolConfig {

    public ThreadPoolExecutor threadPool() {

        int corePoolSize = 1;
        int maxPoolSize = 2;
        long keepAliveTime = 60; // Seconds
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        return new ThreadPoolExecutor(
                corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, queue);

    }


}
