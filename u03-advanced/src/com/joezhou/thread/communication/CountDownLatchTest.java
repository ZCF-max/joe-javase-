package com.joezhou.thread.communication;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

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
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
                    System.out.println(Thread.currentThread().getName() + ": reach destination...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
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