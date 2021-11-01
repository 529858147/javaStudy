package com.how2j.io.socket;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/1 22:18
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> Server.initServer()).start();
        Thread.sleep(1000);//停止一秒钟等待服务器启动后，依次启动客户端
        new Thread(() -> Client.initClient()).start();
    }
}
