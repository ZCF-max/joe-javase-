package com.joezhou.thread.sync;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author JoeZhou
 */
public class AtomicIntegerArrayDemo {

    private static AtomicIntegerArray atomicIntegerArray;

    static {
        int[] arr = new int[]{3, 2};
        atomicIntegerArray = new AtomicIntegerArray(arr);
    }

    public static void main(String[] args) {
        System.out.println("0号元素：" + atomicIntegerArray.get(0));
        System.out.println("0号元素+1后：" + atomicIntegerArray.incrementAndGet(0));
        System.out.println("0号元素-1后：" + atomicIntegerArray.decrementAndGet(0));
        System.out.println("0号元素+6后：" + atomicIntegerArray.addAndGet(0, 6));
        int result = atomicIntegerArray.accumulateAndGet(0, 5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return left * right;
                }
        );
        System.out.println("0号元素*5后：" + result);
    }
}