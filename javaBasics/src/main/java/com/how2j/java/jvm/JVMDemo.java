package com.how2j.java.jvm;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/13 20:54
 */
public class JVMDemo {
    //-Xms8m -Xmx8m -XX:+PrintGCDetails
    //-Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        String str = "test";
        while (true) {
            str += str;
        }
    }
}
