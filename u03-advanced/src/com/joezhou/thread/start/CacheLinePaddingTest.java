package com.joezhou.thread.start;

/**
 * @author JoeZhou
 */
public class CacheLinePaddingTest {
    public static long COUNT = 1_0000_0000L;

    private static class Demo {
        //public long p1, p2, p3, p4, p5, p6, p7;
        /**
         * 一个缓存行只有64字节，所以这个x不会同时出现在两个缓存航中
         */
        public volatile long x = 0L;
        //public long p9, p10, p11, p12, p13, p14, p15;
    }

    public static Demo[] demos = new Demo[2];

    static{
        demos[0] = new Demo();
        demos[1] = new Demo();
    }

    public static void main(String[] args) {
        new Thread(()->{
            long start = System.currentTimeMillis();
            for (long i = 0; i < COUNT; i++) {
                demos[0].x = i;
            }
            System.out.println(System.currentTimeMillis()- start);
        }).start();

        new Thread(()->{
            long start = System.currentTimeMillis();
            for (long i = 0; i < COUNT; i++) {
                demos[1].x = i;
            }
            System.out.println(System.currentTimeMillis()- start);
        }).start();
    }
}
