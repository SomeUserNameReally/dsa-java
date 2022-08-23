package com.solar.edu.hashtables;

import java.util.LinkedList;

public class ArrayBackedChainedHashtable<T> {

    private final LinkedList<StoredElement<T>>[] hashtable;

    public ArrayBackedChainedHashtable() {
        @SuppressWarnings("unchecked") final var ht = (LinkedList<StoredElement<T>>[]) new LinkedList[10];

        hashtable = ht;
    }

    public ArrayBackedChainedHashtable(int capacity) {
        @SuppressWarnings("unchecked") final var ht = (LinkedList<StoredElement<T>>[]) new LinkedList[capacity];

        hashtable = ht;
    }

    public void put(String key, T el) {
        final var hash = hash(key);

        if (hashtable[hash] == null) {
            hashtable[hash] = new LinkedList<>();
        }

        hashtable[hash].add(new StoredElement<>(key, el));
    }

    public T get(String key) {
        final var hash = hash(key);

        StoredElement<T> storedElement;
        if (hashtable[hash] != null) {
            // Iterate through linked list at location
            for (StoredElement<T> se : hashtable[hash]) {
                storedElement = se;
                if (storedElement != null && storedElement.key().equals(key)) return storedElement.el();
            }
        }

        return null;
    }

    public T remove(String key) {
        final var hash = hash(key);

        StoredElement<T> storedElement;
        if (hashtable[hash] != null) {
            // Iterate through linked list at location
            for (StoredElement<T> se : hashtable[hash]) {
                storedElement = se;
                if (storedElement != null && storedElement.key().equals(key)) {
                    hashtable[hash].remove(storedElement);
                    return storedElement.el();
                }
            }
        }

        return null;
    }


    private int hash(String key) {
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            final var llEl = hashtable[i];

            if (llEl == null || llEl.isEmpty()) System.out.println("NULL");
            else {
                System.out.print("Element at " + i + ": ");
                for (StoredElement<T> se : llEl) System.out.print(se);
                System.out.println();
            }
        }
    }
}
