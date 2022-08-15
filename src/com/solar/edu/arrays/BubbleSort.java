package com.solar.edu.arrays;

import com.solar.edu.shared.Utils;

public class BubbleSort {
    public static void sortAsc(int[] array) {
        if ((array == null) || (array.length == 0)) return;
        
        if (array.length > 1) {
            int unsortedIndex = array.length - 1;
            while (unsortedIndex-- > 0) {
                for (int i = 0; i <= unsortedIndex; i++) {
                    if (i == array.length - 1) continue;
                    if (array[i] > array[i + 1]) Utils.swap(array, i, i + 1);
                }
            }
        }

        Utils.printArray(array);
    }
}
