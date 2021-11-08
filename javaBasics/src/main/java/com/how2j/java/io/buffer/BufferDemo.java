package com.how2j.java.io.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/3 20:55
 */
public class BufferDemo {
    public static void main(String[] args) {
        /**
         * java NIO系列之缓冲区Buffer:
         *
         * 主要负责数据的存取，其底层的实现就是数组，用于存储不同数据类型的数据，
         * 根据不同的数据类型（Boolean除外），提供相应类型的缓冲区：
         * ByteBuffer
         * ShortBuffer
         * IntBuffer
         * LongBuffer
         * FloatBuffer
         * DoubleBuffer
         * CharBuffer
         *
         * 这几种Buffer获取缓冲区的方式都是：
         * allocate(size):获取非直接缓冲区
         * allocateDirect(size)获取直接缓冲区
         * size为指定分配大小的缓冲区
         *
         * 缓冲区的四个属性值：
         * 1.capacity:缓冲区的最大容量，一旦声明就不能改变
         * 2.limit:界限，缓冲区中可以操作的数据大小
         * 3.position:缓冲区中正在操作数据的位置
         * 4.mark：记录当前position的位置，可以通过reset()恢复到mark的位置
         */
        BufferDemo bufferDemo = new BufferDemo();
        String str = "hauhua-BufferDemo";
        System.out.println("原字符串：" + str + "，长度：" + str.length());
        bufferDemo.normalBufferAction(str, 1024);
    }

    /**
     * 缓冲区的一般正常操作
     * 1.非直接缓冲区/直接缓冲区
     * 2.常用的操作方法：
     * put()存缓冲区,
     * flip()切换读取数据模式,
     * get()读取缓冲区,
     * rewind()可重复度,
     * clear()清除
     */
    public void normalBufferAction(String str, int size) {
        List<Integer> list = null;
        //1.分配一个指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(size);//非直接缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocateDirect(size);//直接缓冲区
        //判断是否是直接缓冲区
        System.out.println("是否是直接缓冲区buffer.isDirect()：" + buffer.isDirect() + " or " + buffer1.isDirect());
        //获取Buffer的属性值
        list = getBufferProperty(buffer);
        System.out.println("创建后属性：" + "capacity:" + list.get(0) + ",position:" + list.get(1) + ",limit:" + list.get(2));


        //2.存数据到缓冲区
        buffer.put(str.getBytes());
        list = getBufferProperty(buffer);
        System.out.println("存数据后属性：" + "capacity:" + list.get(0) + ",position:" + list.get(1) + ",limit:" + list.get(2));


        //3.切换读取模式
        buffer.flip();
        list = getBufferProperty(buffer);
        System.out.println("切换读取模式后属性：" + "capacity:" + list.get(0) + ",position:" + list.get(1) + ",limit:" + list.get(2));


        //4.读取缓冲区数据
        byte[] destByte = new byte[buffer.limit()];
        destByte[0] = buffer.get();//读取当前position上的数据，读完position+1;
        System.out.println("读一次读到的数据：" + new String(destByte, 0, destByte.length));
        list = getBufferProperty(buffer);
        System.out.println("第一次读取后属性：" + "capacity:" + list.get(0) + ",position:" + list.get(1) + ",limit:" + list.get(2));
        //4.1 mark() 标志
        buffer.mark();//mark()标志
        buffer.get(destByte, 0, 3);
        System.out.println("mark标志后读取到数据：" + new String(destByte));
        list = getBufferProperty(buffer);
        System.out.println("mark标志后读取属性：" + "capacity:" + list.get(0) + ",position:" + list.get(1) + ",limit:" + list.get(2));
        //4.2 reset(),恢复到mark的位置
        buffer.reset();
        list = getBufferProperty(buffer);
        System.out.println("恢复到mark标志后读取属性：" + "capacity:" + list.get(0) + ",position:" + list.get(1) + ",limit:" + list.get(2));
        //4.3判断缓冲区是否还有剩余数据
        if (buffer.hasRemaining()) {
            System.out.println("缓冲区剩余可操作的数量：" + buffer.remaining());
        }

        //5.可重复读，将position位置重置
        buffer.rewind();//可重复读
        buffer.get(destByte);
        System.out.println("重复读取后的数据：" + new String(destByte, 0, destByte.length));
        list = getBufferProperty(buffer);
        System.out.println("重复读取后属性：" + "capacity:" + list.get(0) + ",position:" + list.get(1) + ",limit:" + list.get(2));


        //6.清空缓冲区，但是缓冲区中的数据依然存在，知识处于“被遗忘的状态”,可读的position=limit变成创建时状态
        buffer.clear();
        list = getBufferProperty(buffer);
        System.out.println("清除后属性：" + "capacity:" + list.get(0) + ",position:" + list.get(1) + ",limit:" + list.get(2));
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println("读取清除后的数据：" + new String(bytes));

        list = getBufferProperty(buffer);
        System.out.println("读取清除后属性：" + "capacity:" + list.get(0) + ",position:" + list.get(1) + ",limit:" + list.get(2));

    }

    /**
     * 获取Buffer中三大属性值，[capacity,position,limit]
     *
     * @param buffer
     * @return list
     */
    public List<Integer> getBufferProperty(Buffer buffer) {
        List<Integer> list = new ArrayList<Integer>(3);
        int position = buffer.position();
        int limit = buffer.limit();
        int capacity = buffer.capacity();
        list.add(capacity);
        list.add(position);
        list.add(limit);
        return list;

    }
}
