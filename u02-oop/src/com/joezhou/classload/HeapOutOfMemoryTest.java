package com.joezhou.classload;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JoeZhou
 */
public class HeapOutOfMemoryTest {
    /**
     * 声明类内部静态类，生命周期和外部类HeapOutOfMemory一样长，
     * 使垃圾收集器无法回收这些对象占用的内存空间
     */
    private static class HeapOutOfMemoryInner { }
    @Test
    public void oom(){
        List<HeapOutOfMemoryInner> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOutOfMemoryInner());
            System.out.println(list.size());
        }
    }
}