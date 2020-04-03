package com.sort;

/*
 * 相邻元素作比较
 * */
public class MaoPao {
    public static void main(String[] args) {
        int[] arr = {2, 55, 677, 44, 75, 86, 877};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
