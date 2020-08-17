package com.joezhou.array;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CustomQueueTest {

    private int[] arr = new int[0];

    private boolean add(int element) {
        int[] arrBack = arr;
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = arr.length; i < j; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = element;
        arr = newArr;
        return arrBack.length != arr.length;
    }

    private Integer poll() {
        if (arr.length <= 0) {
            return null;
        }
        int firstElement = arr[0];
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = newArr.length; i < j; i++) {
            newArr[i] = arr[i + 1];
        }
        arr = newArr;
        return firstElement;
    }

    private Integer peek() {
        return arr.length <= 0 ? null : arr[0];
    }

    @Test
    public void api() {
        System.out.println(add(10) ? "add success" : "add fail");
        System.out.println(add(20) ? "add success" : "add fail");
        System.out.println(add(30) ? "add success" : "add fail");
        System.out.println("poll: " + poll());
        System.out.println("peek: " + peek());
    }
}
