package com.joezhou.reference;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @author JoeZhou
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        // -Xms20M -Xmx20M
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(softReference.get() == null);
        System.gc();
        TimeUnit.SECONDS.sleep(1L);
        System.out.println(softReference.get() == null);
        byte[] bs = new byte[1024 * 1024 * 11];
        System.out.println(softReference.get() == null);
    }
}
