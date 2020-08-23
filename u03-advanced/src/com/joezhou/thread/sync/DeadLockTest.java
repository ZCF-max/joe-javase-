package com.joezhou.thread.sync;

/**@author Joe*/
public class DeadLockTest {
	public static void main(String[] args) {
		DeadLockRunnable r = new DeadLockRunnable();
		new Thread(r).start();
		new Thread(r).start();
	}
}

class DeadLockRunnable implements Runnable {

	private final Object obj1 = new Object();
    private final Object obj2 = new Object();

	@Override
	public void run() {
        String t1 = "Thread-0";
		if (Thread.currentThread().getName().equals(t1)) {
			synchronized (obj1) {
				System.out.println("if -- obj1");
				synchronized (obj2) {
					System.out.println("if -- obj2");
				}
			}
		} else {
			synchronized (obj2) {
				System.out.println("else -- obj2");
				synchronized (obj1) {
					System.out.println("else -- obj1");
				}
			}
		}
	}
}