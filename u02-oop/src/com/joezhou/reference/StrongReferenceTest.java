package com.joezhou.reference;

import java.io.IOException;

/**
 * @author JoeZhou
 */
public class StrongReferenceTest {
    public static void main(String[] args) throws IOException {
        Demo demo = new Demo();
        demo = null;
        System.gc();
        // block the main thread...
        System.out.println(System.in.read());
    }
    static class Demo{
        @Override
        protected void finalize() throws Throwable {
            System.out.println("GC会调用finalize()...");
        }
    }
}
