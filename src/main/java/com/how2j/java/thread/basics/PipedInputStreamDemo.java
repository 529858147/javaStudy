package com.how2j.java.thread.basics;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * 1、线程间的通信：字节流，输入
 * 2、线程间的通信：字符流
 * 为什么input是读取,output是写入?
 * 开始一直不明白,明明input是入,output是出. 原来是因为 程序和运行时数据是在内存中驻留的,而input,output都是相对内存来说的
 * input是从磁盘读取到内存 ,
 * output是从内存写到磁盘.
 * @date 2021/8/11 21:16
 */
public class PipedInputStreamDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        Write write = new Write();
        Read read = new Read();

        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedInputStream.connect(pipedOutputStream);

        ThreadWrite threadWrite = new ThreadWrite(write, pipedOutputStream);
        ThreadRead threadRead = new ThreadRead(read, pipedInputStream);
        threadWrite.start();
        threadWrite.join();
        threadRead.start();
    }
}

class ThreadWrite extends Thread {
    private Write write;
    private PipedOutputStream pipedOutputStream;

    public ThreadWrite(Write write, PipedOutputStream pipedOutputStream) {
        this.write = write;
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        super.run();
        try {
            write.writeMethod(pipedOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadRead extends Thread {
    private Read read;
    private PipedInputStream pipedInputStream;

    public ThreadRead(Read read, PipedInputStream pipedInputStream) {
        this.read = read;
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        super.run();
        try {
            read.readMethod(pipedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Write {
    public void writeMethod(PipedOutputStream pipedOutputStream) throws IOException {
        try {
            System.out.println("write: ");

            for (int i = 0; i < 10; i++) {//模拟从存储设备中写入数据到内存中
                pipedOutputStream.write(String.valueOf(i).getBytes());
                System.out.print(i);
            }
            System.out.println("");
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            pipedOutputStream.close();
        }
    }
}

class Read {
    public void readMethod(PipedInputStream pipedInputStream) throws IOException {
        try {
            System.out.println("read: ");
            byte[] bytes = new byte[20];
            int readLength = pipedInputStream.read(bytes);
            while (readLength > 0) {//模拟从内存中读取数据出来
                System.out.print(new String(bytes, 0, bytes.length));
                readLength = pipedInputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pipedInputStream.close();
        }
    }
}
