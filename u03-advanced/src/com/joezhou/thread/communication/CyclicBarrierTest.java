package com.joezhou.thread.communication;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author JoeZhou
 */
public class CyclicBarrierTest {

    @Test
    public void cyclicBarrier() {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(8, () -> {
            System.out.println("broke the cyclicBarrier...");
        });

        for (int i = 0, j = 9; i < j; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ": ready...");
                    cyclicBarrier.await();
                } catch (BrokenBarrierException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": go...");
            }).start();
        }

        for (int i = 0, j = 9; i < j; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + ": ready...");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": go...");
            }).start();
        }
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}