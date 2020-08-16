package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class JosephRingTest {
    @Test
    public void josephRing() {
        JosephRingDemo<String> josephRingTest = new JosephRingDemo<>("1");
        for (int i = 2; i < 10; i++) {
            josephRingTest.add("" + i);
        }
        System.out.println(josephRingTest);
        josephRingTest.kill();
    }
}
