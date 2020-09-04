package com.joezhou.thread.communication;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class PhaserTest {

    private static Phaser phaser;

    @Before
    public void before() {
        phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                if (phase == 0) {
                    System.out.println(">> 共计" + registeredParties + "人通过第1关\n");
                    return false;
                }
                if (phase == 1) {
                    System.out.println(">> 共计" + registeredParties + "人通过第2关\n");
                    return false;
                }
                if (phase == 2) {
                    System.out.println(">> 共计" + registeredParties + "人通过第3关\n");
                    return false;
                }
                return true;
            }
        };
    }

    private static class Hero implements Runnable {

        private int heroLevel;

        private Hero(int heroLevel) {
            this.heroLevel = heroLevel;
        }

        @SneakyThrows
        private void roundOne() {
            TimeUnit.SECONDS.sleep(1L);
            System.out.println(Thread.currentThread().getName() + " 通过第1关...");
            phaser.arriveAndAwaitAdvance();
        }

        @SneakyThrows
        private void roundTwo() {
            if (heroLevel > 2) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println(Thread.currentThread().getName() + " 通过第2关...");
                phaser.arriveAndAwaitAdvance();
            }
        }

        @SneakyThrows
        private void roundThree() {
            if (heroLevel > 4) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println(Thread.currentThread().getName() + " 通过第3关...");
                phaser.arriveAndAwaitAdvance();
            }
            phaser.arriveAndDeregister();
        }

        @Override
        public void run() {
            roundOne();
            roundTwo();
            roundThree();
        }
    }

    @Test
    public void phaser() {
        phaser.bulkRegister(6);
        new Thread(new Hero(1), "thread-1").start();
        new Thread(new Hero(2), "thread-2").start();
        new Thread(new Hero(3), "thread-3").start();
        new Thread(new Hero(4), "thread-4").start();
        new Thread(new Hero(5), "thread-5").start();
        new Thread(new Hero(6), "thread-6").start();
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }
}
