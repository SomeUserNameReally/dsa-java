package com.solar.edu.queues;

import java.util.NoSuchElementException;

public class ArrayBackedQueue<T> {
    /**
     * The actual queue implemented as an array.
     */
    private T[] queue;
    private int start;
    private int end;

    public ArrayBackedQueue(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Cannot instantiate queue with non-positive length.");
        }

        @SuppressWarnings("unchecked") T[] q = (T[]) new Object[initialCapacity];
        queue = q;
    }

    public ArrayBackedQueue(T[] q) {
        if (q == null) {
            throw new NullPointerException();
        }

        if (q.length == 0) {
            throw new IllegalArgumentException("Cannot instantiate queue with array of zero length.");
        }

        queue = q;
    }

    /**
     * Adds an element at the end of the queue
     *
     * @param e The element to be added
     */
    public void enqueue(T e) {
        if (size() == queue.length - 1) {
            int numItems = size();
            @SuppressWarnings("unchecked") T[] q = (T[]) new Object[queue.length * 2];

            System.arraycopy(queue, start, q, 0, queue.length - start);
            System.arraycopy(queue, 0, q, queue.length - start, end);

            queue = q;

            start = 0;
            end = numItems;
        }

        queue[end] = e;

        if (end < queue.length - 1) end++;
        else end = 0;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T head = queue[start];
        queue[start] = null;
        start++;

        if (isEmpty()) {
            start = 0;
            end = 0;
        } else if (start == queue.length) {
            start = 0;
        }


        return head;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return queue[start];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Number of elements in the queue
     */
    public int size() {
        return end - start + (start <= end ? 0 : queue.length);
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("<Empty Queue>");
            return;
        }

        if (start <= end) {
            for (int i = start; i < end; i++) {
                System.out.print(queue[i]);
            }
        } else {
            for (int i = start; i < queue.length; i++) {
                System.out.print(queue[i]);
            }

            for (int i = 0; i < end; i++) {
                System.out.print(queue[i]);
            }
        }

        System.out.println();
    }
}
