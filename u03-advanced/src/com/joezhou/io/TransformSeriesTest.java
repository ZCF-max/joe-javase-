package com.joezhou.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author JoeZhou
 */
public class TransformSeriesTest {
    private static void inputStreamReader() {
        // System.in is typeof InputStream
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str;
            while ((str = br.readLine()) != null) {
                if ("exit".equals(str)) {
                    break;
                }
                System.out.println(">> " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        inputStreamReader();
    }

    @Test
    public void outputStreamWriter() throws IOException {
        String destPath = "D:" + File.separator + "java-io" + File.separator + "hello.txt";
        OutputStreamWriter osw = null;
        try {
            FileOutputStream fos = new FileOutputStream(destPath);
            osw = new OutputStreamWriter(fos);
            osw.write("你好");
            System.out.println(osw.getEncoding());
            osw.flush();
            osw = new OutputStreamWriter(fos, "GBK");
            osw.write("世界");
            System.out.println(osw.getEncoding());
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                osw.close();
            }
        }
    }

}
