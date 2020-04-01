package com.java.io22;

import java.io.File;

/*
 * File 类判断功能
 * */
public class FileDemo4 {
    public static void main(String[] args) {
        function_1();
    }

    /*
     * File判断功能
     * boolean isDirectory()
     * 判断File构造方法中封装的路径是否存在
     * */
    public static void function_1() {
        File file = new File("d:\\java");
        System.out.println(file.isDirectory());
    }

    /*
     * File判断功能
     * boolean exists()
     * 判断File构造方法中封装的路径是否存在
     * */
    public static void function() {
        File file = new File("d:\\java\\java.xmind");
        System.out.println(file.exists());
    }
}
