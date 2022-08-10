package com.solar.edu.linked_lists;

import org.jetbrains.annotations.Nullable;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public void addToFront(T o) {
        Node<T> node = new Node<>(o);

        node.setNext(this.head);
        this.head = node;

        size++;
    }

    public void addToEnd(T o) {
        Node<T> tail = this.getTail();

        if (tail == null) {
            this.addToFront(o);
            return;
        }

        Node<T> node = new Node<>(o);
        tail.setNext(node);

        size++;
    }

    public @Nullable Node<T> removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        Node<T> temp = this.head;
        this.head = this.head.getNext();
        temp.setNext(null);
        size--;
        return temp;
    }

    public @Nullable Node<T> removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        Node<T> penultimateNode = this.getPenultimateNode();

        if (penultimateNode == null) {
            return null;
        }

        Node<T> removedNode = penultimateNode.getNext();
        penultimateNode.setNext(null);
        this.size--;

        return removedNode;
    }

    private @Nullable Node<T> getTail() {
        if (isEmpty()) {
            return null;
        }

        Node<T> cursor = this.head;

        while (cursor.getNext() != null) {
            cursor = cursor.getNext();
        }

        return cursor;
    }

    private @Nullable Node<T> getPenultimateNode() {
        if (isEmpty()) {
            return null;
        }

        Node<T> cursor = this.head;

        while ((cursor.getNext() != null) && (cursor.getNext().getNext() != null)) {
            cursor = cursor.getNext();
        }

        return cursor;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void printList() {
        Node<T> n = this.head;

        System.out.print("Head --> ");
        while (n != null) {
            System.out.print(n.getO());
            System.out.print(" --> ");
            n = n.getNext();
        }
        System.out.println("NULL");
    }
}
