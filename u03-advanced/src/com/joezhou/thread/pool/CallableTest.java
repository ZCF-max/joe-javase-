package com.joezhou.thread.pool;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author JoeZhou
 */
public class CallableTest {

    @SneakyThrows
    @Test
    public void callable(){
        // can instead of lambda..
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(2L);
                return 1;
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        // non-blocking
        Future<Integer> future = executorService.submit(callable);

        System.out.println("thread-main...");
        System.out.println("thread-main...");

        // blocking
        System.out.println(future.get());
        System.out.println("thread-main...");
        System.out.println("thread-main...");

        executorService.shutdown();
    }

    @SneakyThrows
    @After
    public void after(){
        System.out.println(System.in.read());
    }
}
