package com.joezhou.thread;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class ForegroundThreadTest {

    @Test
    public void buildByThread(){
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 10; i++) {
                    System.out.println(Thread.currentThread());
                }
            }
        }.start();
    }

    @Test
    public void buildByRunnable(){
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
    public void buildByLambda(){
        new Thread(() -> {
            for (int i = 0, j = 99; i < j; i++) {
                System.out.println(Thread.currentThread());
            }
        }).start();
    }


}
