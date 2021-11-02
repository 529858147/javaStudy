package com.how2j.io.socketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 使用ServerSocketChannel类
 * @date 2021/11/2 20:09
 */
public class ServerChannel {
    public static void main(String[] args) {
        serverInit();
    }

    public static void serverInit() {
        try {
            //绑定监听的端口号
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(8888);
            serverSocketChannel.bind(inetSocketAddress);

            //设置服务器channel为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //打开一个多路复用选择器
            Selector selector = Selector.open();
            //注册channel进多路复用选择器
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器启动");
            //循环监听selector中注册channel的事件
            while (true) {
                while (selector.select(4000) == 0) {
                    continue;
                }
                //获取被客户端触发的事件set集合
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                System.out.println("开始处理Channel的事件");
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {
                        // 通过选择器键获取服务器套接字通道，通过accept()方法获取套接字通道连接
                        SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
                        socketChannel.configureBlocking(false);
                        // 为套接字通道注册选择器，该选择器为服务器套接字通道的选择器，即选择到该SocketChannel的选择器
                        // 设置选择器关心请求为读操作，设置数据读取的缓冲器容量为处理器初始化时候的缓冲器容量
                        socketChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                        System.out.println("连接一个客户端 : " + socketChannel.getLocalAddress());
                    }
                    if (key.isReadable()) {
                        ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                        SocketChannel channel = (SocketChannel) key.channel();
                        channel.read(byteBuffer);
                        byteBuffer.flip();
                        System.out.println("服务器接收数据：" + Charset.forName("utf-8").decode(byteBuffer));
                        byteBuffer.clear();
                    }
                    // 移除事件，避免重复处理
                    keyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
