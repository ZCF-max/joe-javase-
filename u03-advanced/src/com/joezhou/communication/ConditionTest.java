package com.joezhou.communication;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author JoeZhou
 */
public class ConditionTest {

    private static class ConditionDemo {
        private List<String> list = new ArrayList<>();
        private Lock lock = new ReentrantLock();
        private Condition producer = lock.newCondition();
        private Condition consumer = lock.newCondition();

        public void put(String str) {
            lock.lock();
            try {
                while (list.size() == 10) {
                    producer.await();
                }
                list.add(str);
                consumer.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public String get() {
            String result = null;
            lock.lock();
            try {
                while (list.size() == 0) {
                    consumer.await();
                }
                result = list.remove(0);
                producer.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return result;
        }
    }

    @SneakyThrows
    @Test
    public void condition() {
        ConditionDemo conditionDemo = new ConditionDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int m = 0; m < 5; m++) {
                    System.out.println(Thread.currentThread().getName() + " got: " + conditionDemo.get());
                }
            }, "consumer" + i).start();
        }

        TimeUnit.SECONDS.sleep(2L);

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int m = 0; m < 25; m++) {
                    conditionDemo.put(Thread.currentThread().getName() + ": " + m);
                }
            }, "producer" + i).start();
        }

        System.out.println(System.in.read());
    }

}
