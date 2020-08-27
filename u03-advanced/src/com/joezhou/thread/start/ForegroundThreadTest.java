package com.joezhou.thread.start;

import org.junit.Test;

import java.io.IOException;

/**
 * @author JoeZhou
 */
public class ForegroundThreadTest {

    private static class CustomThread extends Thread {
        @Override
        public void run() {
            for (int i = 0, j = 10; i < j; i++) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void buildByThread() throws IOException {
        CustomThread customThread = new CustomThread();
        customThread.start();
        System.out.println(System.in.read());
    }

    @Test
    public void buildByInnerThread() throws IOException {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0, j = 10; i < j; i++) {
                    System.out.println(i);
                }
            }
        }.start();
        System.out.println(System.in.read());
    }

    @Test
    public void buildByRunnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 10; i++) {
                    System.out.println(Thread.currentThread());
                }
            }
        }).start();
    }

    @Test
    public void buildByLambda() {
        new Thread(() -> {
            for (int i = 0, j = 99; i < j; i++) {
                System.out.println(Thread.currentThread());
            }
        }).start();
    }
}
