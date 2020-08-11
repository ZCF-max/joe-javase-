package com.joezhou.classload;

/**
 * @author JoeZhou
 */
public class StackOverflowErrorDemo {

    private static int stackFrameCount = 0;

    public static void main(String[] args) {
        try {
            method();
        } catch (Throwable e) {
            System.out.println("current stack depth：" + stackFrameCount);
            e.printStackTrace();
        }
    }

    private static void method() {
        stackFrameCount++;
        method();
    }
}

