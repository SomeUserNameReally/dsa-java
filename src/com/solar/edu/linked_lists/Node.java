package com.solar.edu.linked_lists;

public class Node<T> {
    private final T o;
    private Node<T> next;
    private Node<T> previous;

    public Node(T o) {
        this.o = o;
    }

    public T getO() {
        return this.o;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return this.getO().toString();
    }
}
