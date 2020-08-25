package com.joezhou.communication;

import lombok.Data;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class WaitNotifyTest {

    @Data
    private static class Food {
        private String name;
        private String type;
        private boolean exist;
    }

    private static class AsyncProducer implements Runnable {

        private final Food food;
        private boolean flag;

        AsyncProducer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                if (flag) {
                    food.setName("cake");
                    food.setType("Mickey");
                } else {
                    food.setName("dan-gao");
                    food.setType("mi-qi");
                }
                flag = !flag;
            }
        }
    }

    private static class AsyncConsumer implements Runnable {

        private final Food food;

        AsyncConsumer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                    System.out.print(food.getName() + ": " + food.getType() + "\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class SyncProducer implements Runnable {

        private final Food food;
        private boolean flag;

        SyncProducer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                // Don't use "synchronized (this)"
                synchronized (food) {
                    if (flag) {
                        food.setName("cake");
                        food.setType("Mickey");
                    } else {
                        food.setName("dan-gao");
                        food.setType("mi-qi");
                    }
                    flag = !flag;
                    food.setExist(true);
                    food.notify();
                }
            }
        }
    }

    private static class SyncConsumer implements Runnable {

        private final Food food;

        SyncConsumer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (food) {
                    try {
                        TimeUnit.SECONDS.sleep(1L);
                        System.out.print(food.getName() + ": " + food.getType() + "\n");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    private static class OneByOneProducer implements Runnable {

        private final Food food;
        private boolean flag;

        OneByOneProducer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (food) {
                    try {
                        if (food.isExist()) {
                            food.wait();
                        } else {
                            if (flag) {
                                food.setName("cake");
                                food.setType("Mickey");
                            } else {
                                food.setName("dan-gao");
                                food.setType("mi-qi");
                            }
                            flag = !flag;
                            food.setExist(true);
                            food.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class OneByOneConsumer implements Runnable {

        private final Food food;

        OneByOneConsumer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (food) {
                    try {
                        if (food.isExist()) {
                            TimeUnit.SECONDS.sleep(1L);
                            System.out.print(food.getName() + ": " + food.getType() + "\n");
                            food.setExist(false);
                            food.notify();
                        } else {
                            food.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    private Food food = new Food();

    /**
     * Production and consumption are asynchronous
     */
    @Test
    public void asynchronousVersion() throws IOException {
        new Thread(new AsyncProducer(food)).start();
        new Thread(new AsyncConsumer(food)).start();
        System.out.println(System.in.read());
    }


    /**
     * Production and consumption are synchronized
     */
    @Test
    public void synchronizedVersion() throws IOException {
        new Thread(new SyncProducer(food)).start();
        new Thread(new SyncConsumer(food)).start();
        System.out.println(System.in.read());
    }

    /**
     * Production and consumption are synchronized,
     * and Produce one, consume one, Produce one, consume one...
     */
    @Test
    public void oneByOneVersion() throws IOException {
        new Thread(new OneByOneProducer(food)).start();
        new Thread(new OneByOneConsumer(food)).start();
        System.out.println(System.in.read());
    }
}


