package com.solar.edu.shared;

public class Utils {
    public static void printArray(int[] array) {
        if (array == null || array.length == 0) return;

        System.out.print("[ ");
        for (int el: array) System.out.print(el + ", ");
        System.out.println("]");
    }

    public static void swap(int[] array, int firstIndex, int secondIndex) {
        if (array == null || array.length < 2 || firstIndex > array.length - 1 || secondIndex > array.length - 1) return;
        if (firstIndex < 0 || secondIndex < 0 || firstIndex == secondIndex || array[firstIndex] == array[secondIndex]) return;

        final int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
