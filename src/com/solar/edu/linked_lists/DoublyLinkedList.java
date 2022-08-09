package com.solar.edu.linked_lists;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void addToFront(T o) {
        Node<T> node = new Node<>(o);

        node.setNext(this.head);

        if (isEmpty()) this.tail = node;
        else head.setPrevious(node);

        this.head = node;
        size++;
    }

    public Node<T> removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        Node<T> temp = this.head;

        if (head.getNext() == null) {
            this.tail = null;
        } else {
            this.head.getNext().setPrevious(null);
        }

        this.head = this.head.getNext();
        temp.setNext(null);

        size--;
        return temp;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public void printList() {
        Node<T> n = this.head;

        System.out.print("HEAD --> ");
        while (n != null) {
            System.out.print(n.getO());
            if (n.getNext() == null) {
                System.out.print(" [TAIL] ");
                System.out.print(" --> ");
            } else {
                System.out.print(" <==> ");
            }
            n = n.getNext();
        }
        System.out.println("NULL");
    }

    public int getSize() {
        return this.size;
    }
}
