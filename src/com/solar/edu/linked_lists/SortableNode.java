package com.solar.edu.linked_lists;

public class SortableNode<T extends Integer> implements ISortableNode<T> {
    final private T o;
    private SortableNode<T> prev;
    private SortableNode<T> next;

    public SortableNode(T o) {
        this.o = o;
    }

    public T getO() {
        return this.o;
    }

    public SortableNode<T> getPrev() {
        return prev;
    }

    public void setPrev(SortableNode<T> prev) {
        this.prev = prev;
    }

    public SortableNode<T> getNext() {
        return next;
    }

    public void setNext(SortableNode<T> next) {
        this.next = next;
    }

    @Override
    public int compareTo(T o) {
        return this.o.compareTo(o);
    }

    @Override
    public String toString() {
        return this.getO().toString();
    }
}
