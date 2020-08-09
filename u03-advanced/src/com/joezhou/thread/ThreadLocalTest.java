package com.joezhou.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class ThreadLocalTest {

    private static ThreadLocal<Person> personThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                personThreadLocal.set(new Person());
                System.out.println("1秒钟后Person设置完成...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(personThreadLocal.get() == null ? "2秒钟后获取失败.." : "2秒钟后获取成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    static class Person {
        private String name;
    }
}
