package com.list19;

import java.util.ArrayList;
import java.util.List;

/*
* 迭代器的并发修改异常
* */
public class ListDemo1 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
    }
}
