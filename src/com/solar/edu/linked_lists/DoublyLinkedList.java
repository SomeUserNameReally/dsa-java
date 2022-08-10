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

        if (isEmpty()) this.tail = node;
        else {
            head.setPrevious(node);
            node.setNext(this.head);
        }

        this.head = node;
        this.size++;
    }

    public void addToEnd(T o) {
        Node<T> node = new Node<>(o);

        if (isEmpty()) this.head = node;
        else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
        }

        this.tail = node;
        this.size++;
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

        this.size--;
        return temp;
    }

    public Node<T> removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        Node<T> node = this.tail;

        if (this.tail.getPrevious() == null) {
            this.head = null;
        } else {
            this.tail.getPrevious().setNext(null);
        }

        this.tail = this.tail.getPrevious();

        this.size--;
        node.setPrevious(null);
        return node;
    }

    public boolean addBefore(T _newO, T _existingO) {
        if (isEmpty() || _existingO == null || _newO == null) {
            return false;
        }

        Node<T> newO = new Node<>(_newO);
        if (this.head.getO().equals(_existingO)) {
            this.head.setPrevious(newO);
            newO.setNext(this.head);
            this.head = newO;
        } else {
            Node<T> cursor = this.head;
            while (cursor != null && cursor.getNext() != null && !cursor.getNext().getO().equals(_existingO)) {
                cursor = cursor.getNext();
            }

            // At the penultimate node
            if (cursor == null || cursor.getNext() == null || !cursor.getNext().getO().equals(_existingO)) {
                return false;
            }

            Node<T> existingNode = cursor.getNext();

            cursor.setNext(newO);
            newO.setPrevious(cursor);

            existingNode.setPrevious(newO);
            newO.setNext(existingNode);
        }

        size++;
        return true;
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
