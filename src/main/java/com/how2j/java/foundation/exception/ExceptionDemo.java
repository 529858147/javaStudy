package com.how2j.java.foundation.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/4 20:56
 */
public class ExceptionDemo {

    public static void main(String[] args) throws CustomException {
        try {
            checkExceptionDemo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            uncheckExceptionDemo();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new CustomException("test");
        }
    }

    /**
     * 关于受检异常
     * 若是使用try catch捕获，则不会抛出上层去处理，catch块内使用了throw exception除外
     */
    public static void checkExceptionDemo() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/text.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    /**
     * 1. 关于运行时异常，都是不受检查的，需要主动识别错误，并且用相关的手段去处理对应的错误
     * 2. 运行时异常需要一一对应才能捕获对应的异常
     */
    public static void uncheckExceptionDemo() throws RuntimeException {

        int a = 10 / 0;
    }

    /**
     * 关于自定义异常，只需要继承对应的父类异常或者错误即可
     * Throwable
     * Exception
     * RuntimeException
     */
    static class CustomException extends Exception {
        public CustomException(String msg) {
            super(msg);
        }
    }
}
