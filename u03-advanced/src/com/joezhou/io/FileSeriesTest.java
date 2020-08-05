package com.joezhou.io;

import org.junit.Test;

import javax.xml.stream.FactoryConfigurationError;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author JoeZhou
 */
public class FileSeriesTest {

    private String filePath = "D:" + File.separator + "java-io" + File.separator + "HelloWorld.java";

    @Test
    public void fileInputStream() {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println("total bytes：" + fis.available());

            // temp var
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileOutputStream() {
        String destPath = "D:" + File.separator + "java-io" + File.separator + "HelloWorld.txt";
        try (FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream(destPath, true)) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
            fos.flush();
            System.out.println("copy over...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
