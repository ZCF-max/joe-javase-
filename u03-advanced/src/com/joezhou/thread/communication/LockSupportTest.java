package com.joezhou.thread.communication;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author JoeZhou
 */
public class LockSupportTest {

    @SneakyThrows
    @Test
    public void lockSupport() {
        Thread thead = new Thread(() -> {
            for (int i = 0, j = 10; i < j; i++) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }
            }
        });
        thead.start();

        try {
            TimeUnit.SECONDS.sleep(8L);
            System.out.println("after 8s...");
            LockSupport.unpark(thead);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
