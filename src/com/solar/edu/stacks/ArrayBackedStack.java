package com.solar.edu.stacks;

import java.util.EmptyStackException;

public class ArrayBackedStack<T> {
    private T[] stack;
    private int top;

    public ArrayBackedStack(int capacity) {
        // Alternative to: T[] a = (T[]) Array.newInstance(e, c);
        @SuppressWarnings("unchecked") T[] a = (T[]) new Object[capacity];

        stack = a;
    }

    public void push(T e) {
        if (top == stack.length) {
            @SuppressWarnings("unchecked") T[] a = (T[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, a, 0, stack.length);

            stack = a;
        }

        stack[top++] = e;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T el = stack[--top];
        stack[top] = null;
        return el;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public void printStack() {
        for (T el : stack) {
            System.out.print(el + ", ");
        }
        System.out.println();
    }
}
