package com.joezhou.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * unpack()如果在pack()之前被调用，则pack()会失效
 *
 * unpack-pack 比 wait-notify 更灵活，unpack可以具体指定唤醒哪个线程
 * notify只能随机唤醒
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
