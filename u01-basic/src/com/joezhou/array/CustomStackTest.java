package com.joezhou.array;

import org.junit.Test;

import java.util.EmptyStackException;

/**
 * @author JoeZhou
 */
public class CustomStackTest {

    private int[] arr = new int[0];

    private int push(int element) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = arr.length; i < j; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = element;
        arr = newArr;
        return element;
    }

    private int pop() {
        if (arr.length == 0) {
            throw new EmptyStackException();
        }
        int lastElement = arr[arr.length - 1];
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = newArr.length; i < j; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        return lastElement;
    }

    private int peek() {
        if (arr.length == 0) {
            throw new EmptyStackException();
        }
        return arr[arr.length - 1];
    }

    @Test
    public void api() {
        push(10);
        push(20);
        push(30);
        System.out.println("peek:" + peek());
        System.out.println("pop:" + pop());
    }
}
