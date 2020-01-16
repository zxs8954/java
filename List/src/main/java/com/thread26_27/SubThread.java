package com.thread26_27;
/*
* 定义子类继承Thread
* */
public class SubThread extends Thread{
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println(i);
        }
    }
}
