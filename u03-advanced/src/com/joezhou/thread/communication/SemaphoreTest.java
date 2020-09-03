package com.joezhou.thread.communication;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 * @author JoeZhou
 */
public class SemaphoreTest {

    private Semaphore semaphore = new Semaphore(2);

    @Test
    public void semaphore() throws IOException {
        for (int i = 0, j = 10; i < j; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " start...");
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
        System.out.println(System.in.read());
    }

}