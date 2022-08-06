package com.solar.edu.linked_lists;

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

    public Node<T> removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        Node<T> temp = this.head;
        this.head = this.head.getNext();
        temp.setNext(null);
        size--;
        return temp;
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
