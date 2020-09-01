package com.joezhou.thread.lock;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class LockUpgradeTest {

    @Test
    public void biasedLock() throws InterruptedException {

        Object obj = new Object();
        // 00000001 => 001: no lock
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        TimeUnit.SECONDS.sleep(5L);

        obj = new Object();
        // 000001(01): anonymous biased lock, and thread-recorded is null
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        synchronized (obj){
            // 00000(101): non-anonymous biased lock, and thread-recorded is main thread
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }

    @Test
    public void selfRotatingLock() {

        Object obj = new Object();
        // 00000001 => 001: no lock
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        synchronized (obj){
            // 11001000(00): self-rotating lock, and thread-recorded is the LR of main thread
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }

    private static class OsLockDemo implements Runnable{

        private final Object obj;

        private OsLockDemo(Object obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            synchronized (obj){
                try {
                    obj.wait();
                    System.out.println("notified...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void osLock() throws InterruptedException {

        Object obj = new Object();
        // 00000001 => 001: no lock
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        OsLockDemo osLockDemo = new OsLockDemo(obj);
        Thread thread = new Thread(osLockDemo);
        thread.start();

        TimeUnit.SECONDS.sleep(5L);
        thread.notify();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
