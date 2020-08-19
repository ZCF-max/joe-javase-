package com.joezhou.thread.sync;

/**
 * @author JoeZhou
 */
public class VolatileTest {

    private static class VolatileDemo implements Runnable {

        private /*volatile*/ boolean flag;

        @Override
        public void run() {
            while (!flag) {
            }
        }

        void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(volatileDemo).start();
        Thread.sleep(2000L);
        volatileDemo.setFlag(true);
        System.out.println("thread-main:over");

    }

}

