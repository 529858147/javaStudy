package com.how2j.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习ServerSocket类
 * @date 2021/11/1 20:48
 */
public class Server {
    public static void main(String[] args) {
        initServer();
    }

    public static void initServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("启动服务器");
            Socket socket = serverSocket.accept();
            System.out.println("客户端: " + socket.getInetAddress() + ":" + socket.getLocalPort() + ",连接服务器成功");
            //构建服务器的IO
            InputStream inputStream = socket.getInputStream();//数据从网卡到内存
            OutputStream outputStream = socket.getOutputStream();//数据从内存到网卡

            //构建缓冲流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            char[] chars = new char[128];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                if ((len = bufferedReader.read(chars)) != -1) {
                    String str = new String(chars, 0, len);
                    stringBuilder.append(str);
                    if (str.indexOf("\n") > -1) {
                        System.out.println("服务器接收数据：" + stringBuilder);
                        bufferedWriter.write("服务器处理数据->" + stringBuilder + "\n");
                        bufferedWriter.flush();
                        stringBuilder.delete(0, stringBuilder.length());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
