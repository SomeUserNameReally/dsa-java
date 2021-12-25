package com.solar.edu.shared;

public class Utils {
    public static void printArray(int[] array) {
        if (array == null || array.length == 0) return;

        System.out.print("[ ");
        for (int el: array) System.out.print(el + ", ");
        System.out.print("]");
    }
}
