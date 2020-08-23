package com.joezhou.thread.collection;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author JoeZhou
 */
public class SynchronizedMapTest {

    @Test
    public void hashTable() {
        Hashtable<String, Object> hashtable = new Hashtable<>();
        hashtable.put("name", "赵四");
        hashtable.put("gender", "male");
        hashtable.put("age", 18);
        hashtable.forEach((i, v) -> {
            System.out.println(v);
        });
        System.out.println(hashtable.size());
    }

    @Test
    public void synchronizedMap() {
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>(3));
    }

    @Test
    public void concurrentHashMap() {
        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>(3);
    }

    @Test
    public void concurrentSkipListMap() {
        // concurrentTreeMap + CAS 太复杂了，所以没有设计，而是设计了一个跳表数据结构的ConcurrentSkipListMap
        // 它适用于高并发，且它可以排序
        ConcurrentSkipListMap<Object, Object> hashMap = new ConcurrentSkipListMap<>();
    }
}
