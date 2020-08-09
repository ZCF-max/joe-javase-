package com.joezhou.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author JoeZhou
 */
public class NonBlockSocketClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(
                new InetSocketAddress("127.0.0.1", 9002));
        socketChannel.configureBlocking(false);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CharsetEncoder charsetEncoder = StandardCharsets.UTF_8.newEncoder();
        String str;
        while ((str = br.readLine()) != null) {
            charBuffer.put("=> " + str);
            charBuffer.flip();
            socketChannel.write(charsetEncoder.encode(charBuffer));
            charBuffer.clear();
        }
        br.close();
        socketChannel.close();
    }
}
