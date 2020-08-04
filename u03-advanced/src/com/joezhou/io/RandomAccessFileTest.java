package com.joezhou.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author JoeZhou
 */
public class RandomAccessFileTest {

    @Test
    public void writeAndRead() {
        String name = "D:\\java\\io\\emp.txt";
        try (RandomAccessFile raf = new RandomAccessFile(name, "rw")) {
            raf.writeUTF("赵四");
            raf.writeInt(18);
            raf.writeUTF("刘能");
            raf.writeInt(28);
            raf.writeUTF("广坤");
            raf.writeInt(38);

            // 位置指示器重置于0号位
            raf.seek(0);
            System.out.print(raf.readUTF() + "\t");

            // 跳过赵四的年龄
            raf.skipBytes(4);
            System.out.print(raf.readUTF() + "\t");
            System.out.print(raf.readInt() + "\t");
            System.out.print(raf.readUTF() + "\t");
            System.out.print(raf.readInt() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}