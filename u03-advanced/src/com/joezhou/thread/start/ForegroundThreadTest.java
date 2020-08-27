package com.joezhou.thread.start;

import org.junit.Test;

import java.io.IOException;

/**
 * @author JoeZhou
 */
public class ForegroundThreadTest {

    private static class SubThread extends Thread {
        @Override
        public void run() {
            for (int i = 0, j = 10; i < j; i++) {
                System.out.println(i);
            }
        }
    }

    private static class SubRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0, j = 10; i < j; i++) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void buildByThread() throws IOException {
        SubThread thread = new SubThread();
        thread.start();
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
    public void buildByRunnable() throws IOException {
        SubRunnable subRunnable = new SubRunnable();
        Thread thread = new Thread(subRunnable);
        thread.start();
        System.out.println(System.in.read());
    }

    @Test
    public void buildByInnerRunnable() throws IOException {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0, j = 10; i < j; i++) {
                    System.out.println(i);
                }
            }
        });
        thread.start();
        System.out.println(System.in.read());
    }

    @Test
    public void buildByLambda() throws IOException {
        new Thread(() -> {
            for (int i = 0, j = 10; i < j; i++) {
                System.out.println(i);
            }
        }).start();
        System.out.println(System.in.read());
    }
}
