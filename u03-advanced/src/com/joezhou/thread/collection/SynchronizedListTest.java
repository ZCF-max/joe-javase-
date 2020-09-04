package com.joezhou.thread.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author JoeZhou
 */
public class SynchronizedListTest {

    @Test
    public void vector() {
        Vector<String> vector = new Vector<>();
        vector.add("赵四");
        System.out.println(vector.get(0));
    }

    @Test
    public void synchronizedList() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("赵四");
        System.out.println(list.get(0));
    }

    @Test
    public void copyOnWriteArrayList() {
        // 写时进行加锁复制，读时不加锁，适用于读线程远远多于写线程的情景
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("赵四");
        System.out.println(list.get(0));
    }


}
