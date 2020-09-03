package com.joezhou.thread.communication;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/**
 * @author JoeZhou
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        // p1：满8人后，摧毁屏障，并执行p2，[p2可选]
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8, ()-> {
            System.out.println("broke the cyclicBarrier...");
        });

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(finalI * 1000L);
                    System.out.println(Thread.currentThread().getName() + "准备就绪");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"开始比赛");
            }).start();
        }

        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(finalI * 1000L);
                    System.out.println(Thread.currentThread().getName() + "准备就绪");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() +"开始比赛");
            }).start();
        }
    }
}