package com.joezhou.thread.start;

import org.junit.Test;

import java.io.IOException;

/**
 * @author JoeZhou
 */
public class ThreadStateTest {
    /**
     * Blocked state is not convenient to test
     */
    @Test
    public void state() throws IOException, InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("hello!");
        });
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());

        thread.join();
        System.out.println(thread.getState());

        System.out.println(System.in.read());
    }
}
