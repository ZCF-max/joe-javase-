package com.joezhou.thread.sync;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class DclSingletonTest {
    private static class DclSingleton {
        private volatile static DclSingleton singleton = null;

        private DclSingleton() {
        }

        public static DclSingleton getInstance() {
            if (singleton == null) {
                synchronized (DclSingleton.class) {
                    if (singleton == null) {
                        singleton = new DclSingleton();
                    }
                }
            }
            return singleton;
        }
    }

    @Test
    public void dclSingleton() {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(DclSingleton.getInstance());
            }).start();
        }
    }
}
