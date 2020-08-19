package com.joezhou.thread.sync;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class ExceptionTest {

    private static class ExceptionDemo implements Runnable{

        private int count;

        @Override
        public synchronized void run() {
            while(true){
                System.out.println(Thread.currentThread().getName() + ":" + count);
                try {
                    if(count++ == 3){
                        System.out.println(1/0);
                    }
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void exception() throws InterruptedException {

        Thread threadA = new Thread(new ExceptionDemo(),"threadA");
        threadA.start();
        threadA.join();

        Thread threadB = new Thread(new ExceptionDemo(),"threadB");
        threadB.start();
        threadB.join();
        System.out.println("test over...");

    }
}
