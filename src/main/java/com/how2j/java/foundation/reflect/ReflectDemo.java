package com.how2j.java.foundation.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello {
    void say(String msg);
}

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/4 21:51
 */
public class ReflectDemo {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        Handler handler = new Handler(hello);
        Class[] classes = {Hello.class};
        Hello h = (Hello) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), classes, handler);
        h.say("test");
        Class clazz = h.getClass();
        Constructor<?>[] constructors = clazz.getConstructors();
        for(Constructor constructor : constructors){
            constructor.setAccessible(true);
            System.out.println(constructor.getParameterTypes());
        }
        System.out.println(clazz.getName());
        System.out.println(clazz.getComponentType());
    }
}

class Handler implements InvocationHandler {
    private Object object;

    public Handler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before");
        Object obj = args[0];
        Object invoke = method.invoke(object,obj);
        return invoke;
    }
}

class HelloImpl implements Hello {
    private String msg;

    public HelloImpl() {
    }

    private HelloImpl(String msg) {
        this.msg = msg;
    }

    @Override
    public void say(String str) {
        System.out.println("String: " + str);
    }

    private void say(int a) {
        System.out.println("int: " + a);
    }
}
