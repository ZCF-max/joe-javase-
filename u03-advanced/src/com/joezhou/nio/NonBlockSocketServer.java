package com.joezhou.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * @author JoeZhou
 */
public class NonBlockSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()
                .bind(new InetSocketAddress(9002));
        serverSocketChannel.configureBlocking(false);
        System.out.println("ready to accept data...");
        CharsetDecoder charsetDecoder = StandardCharsets.UTF_8.newDecoder();
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        SocketChannel socketChannel = null;
        while (selector.select() > 0) {
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = it.next();
                if (selectionKey.isAcceptable()) {
                    socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                else if (selectionKey.isReadable()) {
                    socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    while (socketChannel.read(byteBuffer) > 0) {
                        byteBuffer.flip();
                        CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
                        for (int i = 0, j = charBuffer.limit(); i < j; i++) {
                            System.out.print(charBuffer.get());
                        }
                        System.out.println();
                        byteBuffer.clear();
                    }
                }
                it.remove();
            }
        }
        if (socketChannel != null) {
            socketChannel.close();
        }
        serverSocketChannel.close();
    }
}
