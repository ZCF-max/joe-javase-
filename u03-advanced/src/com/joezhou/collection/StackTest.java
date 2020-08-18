package com.joezhou.collection;

import org.junit.Test;

import java.util.Stack;

/**
 * @author JoeZhou
 */
public class StackTest {

    @Test
    public void api() {
        Stack<Integer> stack = new Stack<>();
        System.out.println("push: " + stack.push(1));
        System.out.println("push: " + stack.push(2));
        System.out.println("push: " + stack.push(3));
        System.out.println("push: " + stack.push(4));
        System.out.println("peek: " + stack.peek());
        System.out.println("search: " + stack.search(3));
        System.out.print("for: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
    }
}
