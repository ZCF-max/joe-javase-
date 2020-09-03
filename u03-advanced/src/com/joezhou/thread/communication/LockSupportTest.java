package com.joezhou.thread.communication;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 *
 * @author JoeZhou
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread thead = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
}
