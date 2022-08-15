package com.solar.edu.stacks;

import com.solar.edu.linked_lists.DoublyLinkedList;

import java.util.EmptyStackException;

public class LinkedListBackedStack<T> {
    final private DoublyLinkedList<T> stack;

    public LinkedListBackedStack() {
        stack = new DoublyLinkedList<>();
    }

    public LinkedListBackedStack(T el) {
        stack = new DoublyLinkedList<>();
        stack.addToEnd(el);
    }

    public LinkedListBackedStack(DoublyLinkedList<T> sll) {
        stack = sll;
    }

    public void push(T e) {
        stack.addToEnd(e);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.removeFromEnd().getO();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.getTail().getO();
    }

    public int size() {
        return stack.getSize();
    }

    public boolean isEmpty() {
        return stack == null || stack.getSize() == 0 || stack.isEmpty();
    }

    public void printStack() {
        stack.printList();
    }
}
