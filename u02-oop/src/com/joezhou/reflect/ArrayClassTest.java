package com.joezhou.reflect;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class ArrayClassTest {
    @Test
    public void arrayTypeTest() {
        Class<?> class01 = new int[10].getClass();
        Class<?> class02 = new int[20].getClass();
        Class<?> class03 = new int[10][10][10].getClass();
        Class<?> class04 = new double[10].getClass();
        System.out.println(class01 == class02);
        System.out.println(class01 == class03);
        System.out.println(class01 == class04);
    }
}
