package com.joezhou.thread.collection;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Test;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author JoeZhou
 */
public class BlockQueueTest {

    private static class MyTask implements Delayed {

        private String taskName;
        private Long timestamp;

        MyTask(String taskName, Long timestamp) {
            this.taskName = taskName;
            this.timestamp = timestamp;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(timestamp - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return taskName + ": " + timestamp;
        }
    }

    @Test
    public void concurrentLinkedQueue() {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add("zhao-si");
        System.out.println(queue.poll());
    }

    @Test
    public void linkedBlockingQueue() {
        BlockingQueue<Integer> list = new LinkedBlockingQueue<>(5);
        System.out.println(list.isEmpty());
        new Thread(() -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(2L);
                    int data = new Random().nextInt(100);
                    list.put(data);
                    System.out.println("produce: " + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer").start();

        for (int i = 0, j = 5; i < j; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " : " + list.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer-" + i).start();
        }
    }

    @Test
    public void linkedBlockingDeque() {
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>();
        list.addFirst("zhao-si");
        list.addLast("liu-neng");
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        System.out.println(list);
    }

    @SneakyThrows
    @Test
    public void arrayBlockingQueue() {
        BlockingQueue<Integer> list = new ArrayBlockingQueue<>(10);
        for (int i = 0, j = 10; i < j; i++) {
            list.put(i);
        }
        System.out.println(list.size());

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3L);
                System.out.println(list.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // blocking and wait for consumer
        list.put(250);
        System.out.println("over...");
    }

    @SneakyThrows
    @Test
    public void delayQueue() {
        BlockingQueue<MyTask> list = new DelayQueue<>();
        long now = System.currentTimeMillis();
        list.put(new MyTask("task1", now + 3));
        list.put(new MyTask("task4", now + 1));
        list.put(new MyTask("task5", now + 2));
        for (int i = 0, j = list.size(); i < j; i++) {
            System.out.println(list.take());
        }
    }

    @Test
    public void synchronousQueue() throws Exception {
        // SynchronousQueue的初始容量为0，它不是用来装数据的，是用来向其他线程传递数据的
        // 不能调用add方法，直接报错。
        BlockingQueue<String> list = new SynchronousQueue<>();

        // 该线程等待输出，什么时候有人put值，它什么时候take到值
        new Thread(() -> {
            try {
                System.out.println(list.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        list.put("aaa");
        System.out.println(list.size());
        System.out.println(System.in.read());
    }

    @Test
    public void transferQueue() throws Exception {
        TransferQueue<String> list = new LinkedTransferQueue<>();

        // 该线程等待输出，什么时候有人put值，它什么时候take到值
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start...");
                Thread.sleep(2000L);
                System.out.println(list.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start...");
                // 向LinkedTransferQueue传递数据后，会阻塞等待，直到有人将数据take()走，它才继续运行。
                list.transfer("aaa");
                // list.put("aaa"); // put完立刻执行下面的代码，不阻塞
                System.out.println("producer继续运行...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "producer").start();

        System.out.println(System.in.read());
    }

    @SneakyThrows
    @After
    public void after() {
        System.out.println(System.in.read());
    }

}
