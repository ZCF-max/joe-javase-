package com.joezhou.classload;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class StackErrorTest {

    private int stackFrameCount = 0;

    @Test
    public void stackOverflowError() {
        try {
            method();
        } catch (Throwable e) {
            System.out.println("current stack depth：" + stackFrameCount);
            e.printStackTrace();
        }
    }

    private void method() {
        stackFrameCount++;
        method();
    }

    public static void main(String[] args) {
        while (true) {
            new Thread(){
                @Override
                public void run() {
                    while (true) {
                        System.out.println("go!");
                    }
                }
            }.start();
        }
    }
}
