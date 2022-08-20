package com.solar.edu.hashtables;

public class ArrayBackedHashtable<T> {
    final private StoredElement<T>[] hashtable;

    public ArrayBackedHashtable(int capacity) {
        @SuppressWarnings("unchecked") var ht = (StoredElement<T>[]) new StoredElement[capacity];
        hashtable = ht;
    }

    public ArrayBackedHashtable() {
        @SuppressWarnings("unchecked") var ht = (StoredElement<T>[]) new StoredElement[10];
        hashtable = ht;
    }

    public void put(String key, T el) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        var hashKey = hash(key);
        if (occupied(hashKey)) {
            // Linear Probing
            var stopIndex = hashKey;

            if (hashKey == hashtable.length - 1) hashKey = 0;
            else hashKey++;

            while (occupied(hashKey) && hashKey != stopIndex) {
                hashKey = (hashKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashKey)) {
            System.out.println("Can't add element with this key: " + key);
        } else {
            hashtable[hashKey] = new StoredElement<>(key, el);
        }
    }

    public T get(String key) {
        var hashKey = find(key);
        if (hashKey == -1 || hashtable[hashKey] == null) return null;

        return hashtable[hashKey].el();
    }

    public boolean occupied(int key) {
        return hashtable[key] != null;
    }

    private int hash(String key) {
        return key.length() % hashtable.length;
    }

    private int find(String key) {
        var hash = hash(key);

        if (hashtable[hash] != null && hashtable[hash].key().equals(key)) return hash;

        var stopIndex = hash;
        if (hash == hashtable.length - 1) hash = 0;
        else hash++;

        while (hash != stopIndex && hashtable[hash] != null && !hashtable[hash].key().equals(key)) {
            hash = (hash + 1) % hashtable.length;
        }

        if (stopIndex == hash) return -1;
        return hash;
    }

    public void printHashtable() {
        for (StoredElement<T> storedElement : hashtable) {
            if (storedElement == null) System.out.println("NULL");
            else System.out.println(storedElement.el());
        }
    }
}
