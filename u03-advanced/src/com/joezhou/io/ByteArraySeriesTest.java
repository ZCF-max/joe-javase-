package com.joezhou.io;

import org.junit.Test;

import java.io.*;

/**
 * @author JoeZhou
 */
public class ByteArraySeriesTest {

    @Test
    public void byteArrayStream() {
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;
        try {
            baos = new ByteArrayOutputStream();
            baos.write(100);
            baos.write(101);
            baos.write(102);
            System.out.println("the length of baosData：" + baos.size());
            baos.flush();

            byte[] byteArray = baos.toByteArray();
            bais = new ByteArrayInputStream(byteArray);
            System.out.println(bais.read());
            System.out.println(bais.read());
            System.out.println(bais.read());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}