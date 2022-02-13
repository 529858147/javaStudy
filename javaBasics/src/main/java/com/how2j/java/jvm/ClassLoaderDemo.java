package com.how2j.java.jvm;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/13 16:20
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        /**
         * 类加载器类型有：
         * bootstrap classloader 加载rt.jar包下的文件
         * extension classloader 加载ext下的文件
         * app classloader 加载用户自定义类
         * 双亲委派机制：
         * 类加载器收到类加载的请求
         * 首先使用根加载器bootstrap classloader加载class文件
         * 若不能使用bootstrap加载，则使用extension classloader加载
         * 若extension不能加载，则使用app classloader加载
         * 总结：委派自己的父类去加载class文件，能加载当前类就使用当前的类加载器，若父类不能加载则使用子类的类加载器去加载
         */
        //测试双亲委派机制
        String str = new String();
        //这里会返回null，因为java包下的类，都是使用bootstrap classloader 加载类文件，而这个类加载器是c++编写的所以获取不到
        System.out.println(str.getClass().getClassLoader());

        ClassLoaderDemo classLoaderDemo = new ClassLoaderDemo();
        System.out.println(classLoaderDemo.getClass().getClassLoader());

    }
}
