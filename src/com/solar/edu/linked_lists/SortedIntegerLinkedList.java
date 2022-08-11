package com.solar.edu.linked_lists;

public class SortedIntegerLinkedList {
    private SortableNode<Integer> head;
    private int size;

    public void insertSorted(Integer i) {
        SortableNode<Integer> node = new SortableNode<>(i);

        if (isEmpty() || this.head.getO() >= i) {
            node.setNext(this.head);
            this.head = node;

            size++;
            return;
        }

        SortableNode<Integer> curr = this.head.getNext();
        SortableNode<Integer> prev = this.head;

        while (curr != null && curr.getO() < i) {
            prev = curr;
            curr = curr.getNext();
        }

        node.setNext(curr);
        prev.setNext(node);

        size++;
    }

    public SortableNode<Integer> getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void printList() {
        SortableNode<Integer> n = this.head;

        System.out.print("Head --> ");
        while (n != null) {
            System.out.print(n.getO());
            System.out.print(" --> ");
            n = n.getNext();
        }
        System.out.println("NULL");
    }
}
