package org.example;

public class MyHashMap {
    private static final int INITIAL_CAPACITY = 16;
    private Node[] table;
    private int size;

    public MyHashMap() {
        table = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = getHash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            Node prev = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }

            prev.next = newNode;
        }

        size++;
    }

    public void remove(Object key) {
        int index = getHash(key);

        if (table[index] == null) {
            return;
        }

        if (table[index].key.equals(key)) {
            table[index] = table[index].next;
            size--;
            return;
        }

        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                prev.next = current.next;
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        table = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    private int getHash(Object key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % table.length;
    }

    private class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}

