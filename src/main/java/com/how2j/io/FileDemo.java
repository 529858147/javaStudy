package com.how2j.io;

import java.io.File;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习File类
 * @date 2021/10/25 20:23
 */
public class FileDemo {

    public static void main(String[] args) {
        File file = new File(".");
        findFile(file);
    }

    /**
     * 输出指定目录的所有文件
     *
     * @param file
     */
    public static void findFile(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File item : listFiles) {
                if (item.isDirectory()) {
                    findFile(item);
                } else if (item.isFile()) {
                    System.out.println(item.getName());
                }
            }
        } else if (file.isFile()) {
            System.out.println(file.getName());
        }
    }
}


