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
    public void hashtable() {
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
    public void synchronizedHashMap() {
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>(3));
    }

    @Test
    public void concurrentHashMap() {
        ConcurrentHashMap<Object, Object> hashMap = new ConcurrentHashMap<>(3);
    }

    @Test
    public void concurrentSkipListMap() {
        // ConcurrentSkipListMap是一个跳表数据结构的高并发Map，查询效率高。
        // 它适用于高并发，且它可以排序，用于替代concurrentTreeMap(不存在，因为树结构的CAS太复杂)
        Map<Object, Object> hashMap = new ConcurrentSkipListMap<>();
    }
}
