package com.solar.edu.tests.arrays;

import com.solar.edu.arrays.BubbleSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BubbleSortTest {

    @Test
    void sortingEmptyArrayResultsInEmptyArray() {
        int[] arrayToBeSorted = new int[0];
        int[] emptyArray = new int[0];
        BubbleSort.sortAsc(arrayToBeSorted);
        assertEquals(0, emptyArray.length);
        assertEquals(0, arrayToBeSorted.length);
        assertEquals(arrayToBeSorted.length, emptyArray.length);
    }

    @Test
    void sortingOneElementProducesNoChange() {
        int[] arrayToBeSorted = new int[]{1};
        BubbleSort.sortAsc(arrayToBeSorted);
        assertEquals(1, arrayToBeSorted.length);
        assertEquals(1, arrayToBeSorted[0]);
    }

    @Test
    void sortingTwoElementArraySortsAsExpected() {
        int[] arrayToBeSorted = new int[]{2, 1};
        BubbleSort.sortAsc(arrayToBeSorted);
        assertEquals(2, arrayToBeSorted.length);
        assertEquals(1, arrayToBeSorted[0]);
        assertEquals(2, arrayToBeSorted[1]);
    }

    @Test
    void sortingNegativeElementWorksAsExpected() {
        int[] arrayToBeSorted = new int[]{1, -1, 0};
        BubbleSort.sortAsc(arrayToBeSorted);
        assertEquals(3, arrayToBeSorted.length);
        assertEquals(-1, arrayToBeSorted[0]);
        assertEquals(0, arrayToBeSorted[1]);
        assertEquals(1, arrayToBeSorted[2]);
    }

}