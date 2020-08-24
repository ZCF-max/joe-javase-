package com.joezhou.collection;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author JoeZhou
 */
public class QueueTest {

    private Queue<Integer> queue;

    @Before
    public void before() {
        queue = new LinkedList<>();
    }

    @Test
    public void create() {
        System.out.println(queue.add(1) ? "add success" : "add fail");
        System.out.println(queue.add(2) ? "add success" : "add fail");
        System.out.println(queue.offer(3) ? "offer success" : "offer fail");
        System.out.println(queue.offer(4) ? "offer success" : "offer fail");
        System.out.println("create over: " + queue);
    }

    @Test
    public void retrieve() {
        this.create();
        System.out.println("element: " + queue.element());
        System.out.println("peek: " + queue.peek());
    }

    @Test
    public void delete() {
        this.create();
        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue);
    }

    @Test
    public void iteratorByForEach() {
        for (int e : queue) {
            System.out.println(e);
        }
    }

    @Test
    public void iteratorByPoll() {
        while (!queue.isEmpty()) {
            System.out.println("poll: " + queue.poll());
        }
    }
}
