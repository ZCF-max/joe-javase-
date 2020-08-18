package com.joezhou.thread;

/*** @author JoeZhou*/
public class DaemonThreadTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread());
            }
        });

        // 把t1设置成了守护线程，如果想把某一个线程设置为守护线程，必须在启动之前去设置
        t1.setDaemon(true);
        t1.start();
        
        for (int i = 0, j = 50; i < j; i++) {
            System.out.println(Thread.currentThread() + " : " + i);
        }
    }
}