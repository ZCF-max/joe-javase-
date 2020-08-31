package com.joezhou.thread.collection;

import org.junit.Test;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author JoeZhou
 */
public class BlockQueueTest {

    private static class MyTask implements Delayed {

        private String taskName;
        private Long time;

        MyTask(String taskName, Long time) {
            this.taskName = taskName;
            this.time = time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            // (x < y) ? -1 : ((x == y) ? 0 : 1)
            return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public String toString() {
            return taskName + ":" + time;
        }
    }


    @Test
    public void linkedBlockingDeque() throws IOException {
        // BlockingQueue天生就是生产消费者模型，最大不能超过int最大值，存多少都可以
        BlockingQueue<String> list = new LinkedBlockingQueue<>();
        new Thread(() -> {
            try {
                while (true) {
                    // 如果队列满了会阻塞（等待消费）
                    list.put("" + new Random().nextInt(100));
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        // 如果队列空了会阻塞（等待生产）
                        System.out.println(Thread.currentThread().getName() + " : " + list.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer-00" + i).start();
        }

        System.out.println(System.in.read());
    }

    @Test
    public void arrayBlockingQueue() throws Exception {
        // ArrayBlockingQueue必须指定初始容量，且这个容量值永远不变
        BlockingQueue<Integer> list = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            list.put(i);
        }
        System.out.println(list.size());
        // 程序阻塞在这里，等待消费
        list.put(250);
        System.out.println("over...");
    }

    @Test
    public void delayQueue() throws Exception  {
        // DelayQueue可以按照时间来进行任务调度
        BlockingQueue<MyTask> list = new DelayQueue<>();
        long now = System.currentTimeMillis();
        list.put(new MyTask("t1", now + 3));
        list.put(new MyTask("t4", now + 1));
        list.put(new MyTask("t5", now + 2));
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

}
