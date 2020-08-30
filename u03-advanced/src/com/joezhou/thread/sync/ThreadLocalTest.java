package com.joezhou.thread.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class ThreadLocalTest {
    private static class Person {
        private String name;
    }
    private static ThreadLocal<Person> personThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1L);
                personThreadLocal.set(new Person());
                System.out.println("1秒钟后Person设置完成...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2L);
                System.out.println(personThreadLocal.get() == null ? "2秒钟后获取失败.." : "2秒钟后获取成功");
                personThreadLocal.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}