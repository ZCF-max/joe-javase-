package com.joezhou.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author JoeZhou
 */
public class WorkTest {

    @Test
    public void markAndReset() {
        String str = "abcdefg";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        byteBuffer.position(2).mark();
        System.out.print((char) byteBuffer.get());
        System.out.print((char) byteBuffer.get());
        System.out.print((char) byteBuffer.get());
        byteBuffer.reset();
        System.out.print((char) byteBuffer.get());
        System.out.print((char) byteBuffer.get());
        System.out.print((char) byteBuffer.get());
    }

}
