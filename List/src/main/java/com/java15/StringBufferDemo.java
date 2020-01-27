package com.java15;

import java.util.Scanner;

public class StringBufferDemo {
    public static void main(String[] args) {
        function();
    }
    /*
        append,将任意类型的数据添加缓冲区
    */

    public static void function() {
        StringBuffer sb = new StringBuffer();
        sb.append(6);
        System.out.println(sb);
    }

}
