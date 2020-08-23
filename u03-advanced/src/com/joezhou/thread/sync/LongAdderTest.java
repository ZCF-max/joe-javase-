package com.joezhou.thread.sync;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author JoeZhou
 */
public class LongAdderTest {

    private static LongAdder longAdder = new LongAdder();

    public static void main(String[] args) {
        longAdder.add(5);
        System.out.println("当前值+5后：" + longAdder);
        longAdder.increment();
        System.out.println("当前值+1后：" + longAdder);
        longAdder.decrement();
        System.out.println("当前值-1后：" + longAdder);
    }
}