package com.joezhou.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author JoeZhou
 */
public class BufferTest {

    @Test
    public void build() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.isDirect() ? "direct..." : "heap...");
    }

    @Test
    public void coreAttributes() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.position(0).limit(1024);
        System.out.println("capacity: " + byteBuffer.capacity());
        System.out.println("position: " + byteBuffer.position());
        System.out.println("limit: " + byteBuffer.limit());
    }

    @Test
    public void byteBufferTest() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("hello".getBytes());
        byteBuffer.put("world".getBytes());

        byteBuffer.flip();
        System.out.println("flip: " + new String(byteBuffer.array()));

        byteBuffer.rewind();
        System.out.println("rewind: " + new String(byteBuffer.array()));

        byteBuffer.clear();
        System.out.print("clear: ");
        System.out.print((char) byteBuffer.get());
        System.out.print((char) byteBuffer.get());

        System.out.print("\nremaining: ");
        if (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.remaining());
        }
    }

    @Test
    public void work01() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("abcdefg".getBytes());
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
