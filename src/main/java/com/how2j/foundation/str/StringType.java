package com.how2j.foundation.str;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description: 学习String, StringBuilder, StringBuffer
 * @date 2021/10/11 20:33
 */
public class StringType {
    public static void main(String[] args) {
        str();
        System.out.println("=========================");
        strBufferAndBuilder();
    }

    /**
     * String 是不可变的对象，是因为使用了private final char value[]变量来存储字符
     * 每次对 String 类型进行改变的时候其实都等同于生成了一个新的 String 对象，然后将指针指向新的 String 对象
     * String Pool：用来存储String的字面量，当常量池存在相同字符串时，会从常量池中取值
     * new String("a")说明: 当stringPool中存在字符串“a”时，则只会在堆中创建new String()对象，反之会创建一个new String()对象后，还会再创建一个常量“a”对象
     * 在某些特别情况下， String 对象的字符串拼接其实是被 JVM 解释成了 StringBuilder 对象的拼接，所以有些时候 String 对象的速度并不会比 StringBuilder 对象慢，
     */
    public static void str() {
        //代码1
        String sa = new String("Hello world");
        String sb = new String("Hello world");
        System.out.println("new String()：" + (sa == sb));//false
        //代码2
        String sc = "Hello world";
        String sd = "Hello world";
        System.out.println("constant value: " + (sc == sd));//true
        //代码3
        String sa1 = "ab";
        String sb1 = "cd";
        String sab1 = sa1 + sb1;// sa1 sb1被JVM使用StringBuilder的append进行拼接，生成了新的对象
        String s1 = "abcd";
        System.out.println("string object: " + (sab1 == s1));//false
        //代码4
        String sc2 = "ab" + "cd";//被JVM优化成了“abcd”
        String sd2 = "abcd";
        System.out.println("constant value add: " + (sc2 == sd2));//true
    }

    /**
     * StringBuilder，原因是构造器中使用了 super(str.length() + 16);进行扩容
     * StringBuilder 和 StringBuffer 除了线程安全的区别外基本原理都相同
     * StringBuilder，线程不安全，效率比StringBuffer 快
     * StringBuffer，线程安全，使用了synchronized关键字保证线程安全，效率慢
     * String和StringBuffer的效率问题：
     * 在编译阶段就能够确定的字符串常量，完全没有必要创建String或StringBuffer对象。直接使用字符串常量的"+"连接操作效率最高。
     * StringBuffer对象的append效率要高于String对象的"+"连接操作。
     */
    public static void strBufferAndBuilder() {
        StringBuffer stringBuffer = new StringBuffer("abc");
        StringBuilder stringBuilder = new StringBuilder("abc");
    }
}
