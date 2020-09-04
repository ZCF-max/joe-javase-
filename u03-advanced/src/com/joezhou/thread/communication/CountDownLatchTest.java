package com.joezhou.thread.communication;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author JoeZhou
 */
public class CountDownLatchTest {

    @Test
    public void countDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(8);

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("competition is over...");
        }).start();

        for (int i = 0, j = 8; i < j; i++) {
            new Thread(() -> {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName()
                            + ": reach and current count is "
                            + countDownLatch.getCount());
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}