package org.example;

public class MyQueue {
    private Object[] data;
    private int front;
    private int rear;
    private int size;

    public MyQueue() {
        data = new Object[10];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void add(Object value) {
        if (size == data.length) {
            ensureCapacity();
        }
        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[front];
    }

    public Object poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object value = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        int newCapacity = data.length + 1;
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size - 1;
    }
}

