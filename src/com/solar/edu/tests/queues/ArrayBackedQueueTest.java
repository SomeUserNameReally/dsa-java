package com.solar.edu.tests.queues;

import com.solar.edu.queues.ArrayBackedQueue;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayBackedQueueTest {

    @Test
    public void creatingInvalidLengthQueueThrows() {
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> new ArrayBackedQueue<>(-1), "ArrayBackedQueue instantiation with negative capacity expected to fail but succeeded, or didn't throw appropriate error.");

        Exception e2 = assertThrows(IllegalArgumentException.class, () -> new ArrayBackedQueue<>(0), "ArrayBackedQueue instantiation with zero capacity expected to fail but succeeded, or didn't throw appropriate error.");

        assertTrue(e1.getMessage().contains("Cannot instantiate"));
        assertTrue(e2.getMessage().contains("Cannot instantiate"));
    }

    @Test
    public void instantiatingWithNullOrEmptyArrayThrows() {
        Exception e1 = assertThrows(IllegalArgumentException.class, () -> new ArrayBackedQueue<>(new Object[]{}), "ArrayBackedQueue instantiation with zero length array expected to fail but succeeded, or didn't throw appropriate error.");


        assertThrows(NullPointerException.class, () -> new ArrayBackedQueue<>(null), "ArrayBackedQueue instantiation with null value expected to fail but succeeded, or didn't throw appropriate error.");

        assertTrue(e1.getMessage().contains("Cannot instantiate"));
    }

    @Test
    public void peekThrowsOnEmptyQueue() {
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(1);
        String soleElement = "test";

        q.enqueue(soleElement);
        q.dequeue();

        assertThrows(NoSuchElementException.class, q::peek, "ArrayBackedQueue peek on empty queue expected to fail but succeeded, or didn't throw appropriate error.");
    }

    @Test
    public void peekGivesCorrectObjectOnUnitaryQueue() {
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(1);
        String soleElement = "test";

        q.enqueue(soleElement);

        assertEquals(soleElement, q.peek());
    }

    @Test
    public void peekGivesCorrectObjectOnNonUnitaryQueue() {
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(1);
        String first = "first";
        String second = "second";

        q.enqueue(first);
        q.enqueue(second);

        assertNotEquals(second, q.peek());
        assertEquals(first, q.peek());
    }

    @Test
    public void sizeOfUnitaryQueueIsOne() {
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(1);
        String first = "first";

        q.enqueue(first);

        assertEquals(1, q.size());
    }

    @Test
    public void sizeOfEmptyQueueIsZero() {
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(1);
        String first = "first";

        q.enqueue(first);
        q.dequeue();

        assertEquals(0, q.size());
    }

    @Test
    public void creatingAnUnitaryQueueWorksAsExpected() {
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(1);
        String soleElement = "test";

        q.enqueue(soleElement);

        assertEquals(1, q.size());
        assertFalse(q.isEmpty());
    }

    @Test
    public void enqueueAndDequeWorkAsExpected() {
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(1);
        String soleElement = "test";

        q.enqueue(soleElement);

        assertEquals(soleElement, q.peek());
        assertEquals(1, q.size());
        assertFalse(q.isEmpty());

        String removed = q.dequeue();

        assertEquals(0, q.size());
        assertEquals(soleElement, removed);
        assertTrue(q.isEmpty());
    }

    @Test
    public void queueResizesToAccommodateElements() {
        // Keep this strictly less than number of
        // elements being added to the queue
        final int initialCapacity = 1;
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(initialCapacity);
        String first = "first";
        String second = "second";
        String third = "third";

        assertTrue(initialCapacity >= q.size());

        q.enqueue(first);
        q.enqueue(second);
        q.enqueue(third);

        assertTrue(q.size() > initialCapacity);
        // Since we are queuing 3 elements
        assertTrue(q.size() >= 3);
        assertEquals(first, q.peek());

        q.dequeue();
        assertEquals(second, q.peek());

        q.dequeue();
        assertEquals(third, q.peek());

        q.dequeue();
        assertEquals(0, q.size());
    }

    @Test
    public void removingFromUnitaryQueueWorksAsExpected() {
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(1);
        String soleElement = "test";

        q.enqueue(soleElement);
        String removed = q.dequeue();

        assertEquals(0, q.size());
        assertTrue(q.isEmpty());
        assertEquals(soleElement, removed);

        assertThrows(NoSuchElementException.class, q::peek, "Peeking empty ArrayBackedQueue should fail but succeeded, or didn't throw appropriate error.");

    }

    @Test
    public void queueResizesAsNeeded() {
        final int initialCapacity = 1;
        ArrayBackedQueue<String> q = new ArrayBackedQueue<>(initialCapacity);
        String first = "first";
        String second = "second";

        q.enqueue(first);
        q.enqueue(second);

        assertTrue(q.size() > initialCapacity);
    }

    @Test
    public void repeatedlyAddingAndRemovingDoesntResizeQueue() {
        final int initialCapacity = 4;
        ArrayBackedQueue<Integer> q = new ArrayBackedQueue<>(initialCapacity);

        for (int i = 0; i < initialCapacity * 20; i++) {
            q.enqueue(i);
            if (i > initialCapacity - 1) q.dequeue();
        }

        assertTrue(initialCapacity >= q.size());
    }
}
