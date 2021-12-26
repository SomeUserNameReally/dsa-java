package com.solar.edu.arrays;

import com.solar.edu.shared.Utils;

public class SelectionSort {
    public static void sortAsc (int[] array) {
        if (array == null || array.length == 0) return;
        if (array.length == 1) {
            Utils.printArray(array);
            return;
        }

        for (int sortedIndex = array.length - 1; sortedIndex > 0; sortedIndex--) {
            int indexOfCurrentMax = 0;
            for (int unsortedIndex = 0; unsortedIndex <= sortedIndex; unsortedIndex++)
                if (array[unsortedIndex] > array[indexOfCurrentMax])
                    indexOfCurrentMax = unsortedIndex;

            Utils.swap(array, indexOfCurrentMax, sortedIndex);
        }

        Utils.printArray(array);
    }
}
