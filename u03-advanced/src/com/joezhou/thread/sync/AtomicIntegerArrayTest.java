package com.joezhou.thread.sync;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author JoeZhou
 */
public class AtomicIntegerArrayTest {

    private static AtomicIntegerArray arr = new AtomicIntegerArray(new int[]{3, 2});

    @Test
    public void atomicIntegerArray() {
        System.out.println("0号元素：" + arr.get(0));
        System.out.println("0号元素+1后：" + arr.incrementAndGet(0));
        System.out.println("0号元素-1后：" + arr.decrementAndGet(0));
        System.out.println("0号元素-6后：" + arr.addAndGet(0, -6));
        int result = arr.accumulateAndGet(0, 5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return (left - 1) * (right + 9) / 3;
                }
        );
        System.out.println("0号元素计算后：" + result);
    }
}