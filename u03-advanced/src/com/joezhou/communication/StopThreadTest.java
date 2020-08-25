package com.joezhou.communication;

import lombok.Data;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class StopThreadTest {

    @Data
    private static class NormalThread implements Runnable {

        private boolean flag;

        @SneakyThrows
        @Override
        public synchronized void run() {
            while (!flag) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println("thread run...");
            }
            System.out.println("thread over...");
        }
    }

    @Data
    private static class SuspendedThread implements Runnable {

        private boolean flag;

        @SneakyThrows
        @Override
        public synchronized void run() {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    flag = true;
                    e.printStackTrace();
                    System.out.println("thread over...");
                }
            }
        }
    }

    @SneakyThrows
    @Test
    public void stopNormalThread() {
        NormalThread normalThread = new NormalThread();
        new Thread(normalThread).start();
        TimeUnit.SECONDS.sleep(5L);
        normalThread.setFlag(true);
        System.out.println(System.in.read());
    }

    @SneakyThrows
    @Test
    public void stopSuspendedThread() {
        SuspendedThread suspendedThread = new SuspendedThread();
        Thread thread = new Thread(suspendedThread);
        thread.start();
        TimeUnit.SECONDS.sleep(5L);
        thread.interrupt();
        System.out.println(System.in.read());
    }
}