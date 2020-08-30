package com.joezhou.thread.pool;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author JoeZhou
 */
public class FutureTaskTest {
    @SneakyThrows
    @Test
    public void futureTask() {
        // can instead of lambda..
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(2L);
                return 1;
            }
        });

        new Thread(futureTask).start();
        System.out.println("thread-main...");
        System.out.println("thread-main...");

        // blocking
        System.out.println(futureTask.get());
        System.out.println("thread-main...");
        System.out.println("thread-main...");
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
