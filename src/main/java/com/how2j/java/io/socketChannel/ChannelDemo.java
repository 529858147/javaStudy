package com.how2j.java.io.socketChannel;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/2 20:38
 */
public class ChannelDemo {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> ServerChannel.serverInit()).start();

        Thread.sleep(1000);

        new Thread(() -> ClientChannel.clientInit()).start();

    }
}
