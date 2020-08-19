package com.joezhou.thread.start;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class ThreadStateTest {
    /**
     * 阻塞状态不方便测试
     * @throws InterruptedException
     */
    @Test
    public void state() throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("hello!");
        });

        System.out.println(thread.getState());

        thread.start();

        System.out.println(thread.getState());

        thread.join();
        System.out.println(thread.getState());
    }
}
