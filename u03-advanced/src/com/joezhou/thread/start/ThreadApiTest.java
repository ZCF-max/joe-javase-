package com.joezhou.thread.start;

import org.junit.Test;

import java.io.IOException;

/**
 * @author JoeZhou
 */
public class ThreadApiTest {

    @Test
    public void start() throws IOException {
        new Thread(() -> {
            System.out.println("start over...");
        }).start();

        System.out.println(System.in.read());
    }
}
