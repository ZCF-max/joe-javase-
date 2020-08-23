package com.joezhou.thread.sync;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JoeZhou
 */
public class AtomicIntegerDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("当前值：" + atomicInteger.get());
        System.out.println("当前值+1后：" + atomicInteger.incrementAndGet());
        System.out.println("当前值-1后：" + atomicInteger.decrementAndGet());
        System.out.println("当前值+6后：" + atomicInteger.addAndGet(6));
        int result = atomicInteger.accumulateAndGet(5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return left * right;
                }
        );
        System.out.println("当前值*5后：" + result);
    }
}