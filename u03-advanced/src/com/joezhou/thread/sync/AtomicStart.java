package com.joezhou.thread.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JoeZhou
 */
public class AtomicStart {
    private static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(num.incrementAndGet());
                }
            }).start();
        }
    }
}