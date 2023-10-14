package org.example;
import java.util.Arrays;

public class MyArrayList {
    private Object[] data;
    private int size;
    public MyArrayList() {
        data = new Object[10];
        size = 0;
    }
    public void add(Object value) {
        if (size == data.length) {
            ensureCapacity();
        }
        data[size] = value;
        size+=1;
    }
    private void ensureCapacity() {
        int newCapacity = data.length + 2;
        data = Arrays.copyOf(data, newCapacity);
    }
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }
    public void clear() {
        data = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return data[index];
    }

}
