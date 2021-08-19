package com.how2j.thread.basics;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author louis
 * @Title:
 * @Package
 * @Description:
 * 1、学习定时器Timer类的使用
 * 2、Timer类是要作用是设置计划任务，封装任务的类是TimerTask类，执行计划任务的代码要放入TimerTask的子类中，因为TimerTask是一个抽象类
 * @date 2021/8/14 14:47
 */
public class Thread09 {
    public static void main(String[] args) {
        Task task = new Task();
        Timer timer = new Timer();
        timer.schedule(task, new Date(), 5000);
    }
}

class Task extends TimerTask{
    @Override
    public void run() {
        System.out.println("Run Task Time: " + new Date());
    }
}
