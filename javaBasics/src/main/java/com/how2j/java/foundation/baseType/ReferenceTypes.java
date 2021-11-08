package com.how2j.java.foundation.baseType;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:Java的四种引用：强引用，软引用，弱引用，虚引用
 * @date 2021/10/10 16:46
 */
public class ReferenceTypes {
    public static void main(String[] args) {
        StrongReference();
        System.out.println("=================================");
        SoftReference();
        System.out.println("=================================");
        weakReference();
        System.out.println("=================================");
        PhantomReference();
        System.out.println("=================================");
        ReferenceQueueDemo();
    }

    /**
     * 强引用只会在引用指向null时，被垃圾收集器回收
     * 当内存空间不足时，JVM会抛出OutOfMemoryError异常
     */
    public static void StrongReference() {
        Object obejct = new Object();
        System.gc();
        System.out.println("strong reference gc1: " + obejct);
        obejct = null;
        System.gc();
        System.out.println("strong reference gc2: " + obejct);
    }

    /**
     * 软引用是用来描述一些有用但并不是必需的对象。
     * 当内存空间足够，垃圾回收器就不会回收它，当内存空间不足了，就会回收该对象。
     * JVM会优先回收长时间闲置不用的软引用的对象，对那些刚刚构建的或刚刚使用过的“新”软引用对象会尽可能保留。
     * 如果回收完还没有足够的内存，才会抛出内存溢出异常。只要垃圾回收器没有回收它，该对象就可以被程序使用。
     * 适合用来实现缓存(比如浏览器的‘后退’按钮使用的缓存)，内存空间充足的时候将数据缓存在内存中，如果空间不足了就将其回收掉。
     */
    public static void SoftReference() {
        Object object = new Object();
        SoftReference<Object> softReference = new SoftReference<>(object);
        object = null;////去掉强引用，new Object()的这个对象就只有软引用了
        System.gc();
        System.out.println("soft reference gc1: " + softReference.get());
    }

    /**
     * 当垃圾回收器扫描到只具有弱引用的对象时，无论当前内存空间是否足够，都会回收它。
     * 使用场景：一个对象只是偶尔使用，希望在使用时能随时获取，但也不想影响对该对象的垃圾收集，则可以考虑使用弱引用来指向该对象。
     * ThreadLocal中的弱引用：
     * 原理是把ThreadLocal变量以弱key的形式存放在java.lang.ThreadLocal.ThreadLocalMap中。
     * java.lang.ThreadLocal.ThreadLocalMap.Entry就是继承了WeakReference，把ThreadLocal作为一种弱引用存在于map中的key中，
     * 一旦ThreadLocal变量的引用被回收或者被置为null值的时候，JVM就会将数据中的key也回收掉并置为null值。
     */
    public static void weakReference() {
        Object object = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(object);
        System.out.println("weak reference no gc: " + weakReference.get());
        object = null;//去掉强引用，new Object()的这个对象就只有弱引用了
        System.gc();
        System.out.println("weak reference gc: " + weakReference.get());
    }

    /**
     * 与其他三种引用都不同，虚引用并不会决定对象的生命周期。如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收。
     * 虚引用主要用来跟踪对象被垃圾回收的活动。
     * 虚引用必须和引用队列（ReferenceQueue）联合使用。
     */
    public static void PhantomReference() {
        Object object = new Object();
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object, queue);
        object = null;//去掉强引用，new Object()的这个对象就只有虚引用了
        System.gc();
        System.out.println("phantom reference: " + phantomReference.get());
        System.out.println("reference queue: " + queue.poll());
    }

    /**
     * ReferenceQueue实现了一个队列的入队(enqueue)和出队(poll还有remove)操作，内部元素就是泛型的Reference，
     * 并且Queue的实现，是由Reference自身的链表结构( 单向循环链表 )所实现的。
     * 引用队列ReferenceQueue是配合软引用，弱引用，虚引用发生GC时使用的,用来保存被GC收集的对象
     */
    public static void ReferenceQueueDemo() {
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();
        ReferenceQueue queue1 = new ReferenceQueue();
        ReferenceQueue queue2 = new ReferenceQueue();
        ReferenceQueue queue3 = new ReferenceQueue();
        SoftReference<Object> softReference = new SoftReference<>(object1, queue1);
        WeakReference<Object> weakReference = new WeakReference<>(object2, queue2);
        PhantomReference<Object> phantomReference = new PhantomReference<>(object3, queue3);
        object1 = null;
        object2 = null;
        object3 = null;
        System.gc();
        System.out.println("softReference: " + softReference.get() + ", queue: " + queue1.poll());
        System.out.println("weakReference: " + weakReference.get() + ", queue: " + queue2.poll());
        System.out.println("phantomReference: " + phantomReference.get() + ", queue: " + queue3.poll());
    }
}
