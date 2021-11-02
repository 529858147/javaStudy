package com.how2j.io.socketChannel;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习SocketChannel
 * @date 2021/11/2 20:26
 */
public class ClientChannel {
    public static void main(String[] args) {
        clientInit();
    }

    public static void clientInit() {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8888));

            //socketChannel.configureBlocking(false);
            if (socketChannel.isConnected()) {
                System.out.println("客户端连接服务器成功");
            }
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("客户端输入：");
                while (scanner.hasNext()) {
                    String str = scanner.next();
                    //wrap方法并不会更新ByteBuffer的position属性，根据position属性进行操作的api会有影响
                    ByteBuffer byteBuffer = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
                    //使用flip后由于position是0，limit也会变成0，会导致缓冲区根据position和limit读取不出数据,导致write方法写入socket的数据为空，因此监控不到READ
                    //byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                    byteBuffer.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
