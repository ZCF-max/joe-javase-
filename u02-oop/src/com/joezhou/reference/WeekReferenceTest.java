package com.joezhou.reference;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * @author JoeZhou
 */
public class WeekReferenceTest {
    public static void main(String[] args) throws IOException {
        WeakReference<Demo> wrDemo = new WeakReference<>(new Demo());
        System.out.println(wrDemo.get() == null);
        System.gc();
        System.out.println(wrDemo.get() == null);
    }
    static class Demo{
        @Override
        protected void finalize() throws Throwable {
            System.out.println("GC会调用finalize()...");
        }
    }
}
