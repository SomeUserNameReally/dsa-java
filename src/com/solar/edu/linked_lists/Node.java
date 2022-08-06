package com.solar.edu.linked_lists;

public class Node<T> {
    private T o;
    private Node<T> next;

    public Node(T o) {
        this.o = o;
    }

    public T getO() {
        return o;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setO(T o) {
        this.o = o;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.getO().toString();
    }
}
