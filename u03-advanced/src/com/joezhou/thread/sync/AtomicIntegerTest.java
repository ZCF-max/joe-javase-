package com.joezhou.thread.sync;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JoeZhou
 */
public class AtomicIntegerTest {
    private static AtomicInteger num = new AtomicInteger(0);

    @Test
    public void atomicInteger() {
        System.out.println("当前值：" + num.get());
        System.out.println("当前值+1后：" + num.incrementAndGet());
        System.out.println("当前值-1后：" + num.decrementAndGet());
        System.out.println("当前值-6后：" + num.addAndGet(-6));
        int result = num.accumulateAndGet(5, (left, right) -> {
                    System.out.print("left：" + left + "\t");
                    System.out.print("right：" + right + "\n");
                    return (left - 1) * (right - 9) / 3;
                }
        );
        System.out.println("当前值*5后：" + result);
    }
}