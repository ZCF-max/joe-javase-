package com.joezhou.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author JoeZhou
 */
public class CacheLinePaddingTest {
    public static long COUNT = 1_0000_0000L;

    private static class T {
        public long p1, p2, p3, p4, p5, p6, p7;
        /**
         * 一个缓存行只有64字节，所以这个x不会同时出现在两个缓存航中
         */
        public volatile long x = 0L;
        public long p9, p10, p11, p12, p13, p14, p15;
    }

    public static T[] arr = new T[2];

    static{
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(()->{
            for (long i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
            countDownLatch.countDown();
        }).start();

        new Thread(()->{
            for (long i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
            countDownLatch.countDown();
        }).start();
    }
}
