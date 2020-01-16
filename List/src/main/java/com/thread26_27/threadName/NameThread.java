package com.thread26_27.threadName;
/*
*获取线程名字 父类Thread
* */
public class NameThread extends Thread{
    public NameThread(){
        super("小强");
    }
    public void run(){
        System.out.println(Thread.currentThread().getName());
        //System.out.println(super.getName());
    }
}
