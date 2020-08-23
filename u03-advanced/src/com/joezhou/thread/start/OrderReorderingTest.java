package com.joezhou.thread.start;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class OrderReorderingTest {

    private /*volatile*/ int x = 0, y = 0, a = 0, b = 0;

    @Test
    public void orderReorder() throws Exception {

        int count = 0;

        while (true) {

            count++;

            Thread t01 = new Thread(() -> {
                a = 1;
                x = b;
            });

            Thread t02 = new Thread(() -> {
                b = 1;
                y = a;
            });

            t01.start();
            t02.start();
            t01.join();
            t02.join();

            System.out.printf("第%d次：x=%d，y=%d\n", count, x, y);

            if (x == 0 && y == 0) {
                break;
            } else {
                x = 0;
                y = 0;
                a = 0;
                b = 0;
            }
        }

        System.out.println(System.in.read());
    }
}