package com.joezhou.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
}
