package com.how2j.java.io.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习Socket类
 * @date 2021/11/1 20:58
 */
public class Client {
    public static void main(String[] args) {
        initClient();
    }

    public static void initClient() {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
            System.out.println("启动客户端，客户端连接成功：" + socket.isConnected() + ", " + getDate());

            //构建客户端的IO
            InputStream inputStream = socket.getInputStream();//数据从网卡到内存
            OutputStream outputStream = socket.getOutputStream();//数据从内存到网卡

            //构建缓冲流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            char[] chars = new char[128];
            int len;

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("客户端输入：");
                if (scanner.hasNext()) {
                    String str = scanner.next();
                    bufferedWriter.write(str + "\n");
                    bufferedWriter.flush();
                }
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    if ((len = bufferedReader.read(chars)) != -1) {
                        String str = new String(chars, 0, len);
                        stringBuilder.append(str);
                        if (str.indexOf("\n") > -1) {
                            System.out.print(getDate() + ",服务器返回：" + stringBuilder);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(cal.getTime());
        return date;
    }
}
