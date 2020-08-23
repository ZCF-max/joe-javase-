package com.joezhou.thread.start;

import org.junit.Test;

import java.io.IOException;

/**
 * @author JoeZhou
 */
public class EnsureVisibilityByVolatileTest {

    private static class VolatileDemo implements Runnable {

        private /*volatile*/ boolean flag;

        @Override
        public void run() {
            while (!flag) {
                System.out.println();
            }
            System.out.println("thread-sub: over");
        }

        private void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    @Test
    public void ensureVisibility() throws InterruptedException, IOException {
        VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(volatileDemo).start();
        Thread.sleep(2000L);
        volatileDemo.setFlag(true);
        System.out.println("thread-main: over");
        System.out.println(System.in.read());
    }

}

