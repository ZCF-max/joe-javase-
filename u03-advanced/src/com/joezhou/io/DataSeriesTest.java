package com.joezhou.io;

import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * @author JoeZhou
 */
public class DataSeriesTest {

    private String filePath = "D:" + File.separator + "java-io" + File.separator + "a.txt";

    @Test
    public void dataInputStream() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath));
             DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {

            dos.writeInt(250);
            dos.writeBoolean(true);
            dos.writeDouble(3.14);
            dos.flush();

            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
