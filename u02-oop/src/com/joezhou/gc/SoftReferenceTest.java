package com.joezhou.gc;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        // 内存充裕的情况下，软引用和强引用没区别
        // 内存紧张的情况下，软引用会被回收掉。
        byte[] bsA = new byte[1024 * 1024 * 10];
        SoftReference<byte[]> softReference = new SoftReference<>(bsA);
        System.out.println(softReference.get() == null ? "gc" : "exists");
        System.gc();
        TimeUnit.SECONDS.sleep(1L);
        System.out.println(softReference.get() == null ? "gc" : "exists");
        byte[] bsB = new byte[1024 * 1024 * 11];
        System.out.println(softReference.get() == null ? "gc" : "exists");
    }
}