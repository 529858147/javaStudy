package com.how2j.spring.springXmlConfig;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/23 20:55
 */
public class ProxyDemo {
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    public void afterMethod() {
        System.out.println("afterMethod");
    }
}
