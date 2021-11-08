package com.how2j.java.io.ioStream;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/27 21:24
 */
public class IODemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String str = "test!!!!!!!!!!!!!!";
        writerFile(str);
        copyFile();
        transStream();
        serializeDemo();
        deSerializeDemo();
        propertiesDemo();
    }

    /**
     * 当输出流所指向的路径不存在时，会自动在路径下创建文件
     */
    public static void writerFile(String str) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("D:/text.txt")) {
            fileOutputStream.write(str.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try (FileInputStream fileInputStream = new FileInputStream("D:/text.txt")) {
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = fileInputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile() {
        try (InputStream inputStream = new FileInputStream("D:/text.txt"); OutputStream outputStream = new FileOutputStream("D:/copy.txt");) {
            byte[] bytes = new byte[2];
            while (inputStream.read(bytes) != -1) {
                outputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void transStream() throws IOException {
        // 定义文件路径
        String FileName = "D:\\text.txt";
        // 创建流对象,默认UTF8编码
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FileName));
        // 写出数据
        osw.write("测试"); // 保存为6个字节
        osw.close();

        // 定义文件路径
        String FileName2 = "D:\\copy.txt";
        // 创建流对象,指定GBK编码
        OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream(FileName2), "GBK");
        // 写出数据
        osw2.write("测试");// 保存为4个字节
        osw2.close();
    }

    public static void serializeDemo() {
        HashMap map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        try {
            // 创建序列化流对象
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/serialize.txt"));
            // 写出对象
            out.writeObject(map);
            // 释放资源
            out.close();
            System.out.println("Serialized data is saved");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void deSerializeDemo() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/serialize.txt"));
        Map map = (Map) in.readObject();
        in.close();
        System.out.println(map);
    }

    public static void propertiesDemo() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:/properties.txt"));
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String key : propertyNames) {
            System.out.println(key + ": " + properties.getProperty(key));
        }
    }
}
