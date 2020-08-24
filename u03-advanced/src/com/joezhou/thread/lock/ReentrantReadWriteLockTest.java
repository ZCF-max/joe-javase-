package com.joezhou.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author JoeZhou
 */
public class ReentrantReadWriteLockTest {
    private static class ReadWriteLockDemo {
        private ReadWriteLock lock = new ReentrantReadWriteLock();
        private Lock readLock = lock.readLock();
        private Lock writeLock = lock.writeLock();

        void read() {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "：reading...");
                Thread.sleep(5000L);
                System.out.println(Thread.currentThread().getName() + "：read over...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }

        }

        void write() {
            writeLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "：writing...");
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + "：write over...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        new Thread(readWriteLockDemo::read, "reader-A").start();
        new Thread(readWriteLockDemo::read, "reader-B").start();
        new Thread(readWriteLockDemo::write, "writer-A").start();
        new Thread(readWriteLockDemo::write, "writer-B").start();
    }
}

