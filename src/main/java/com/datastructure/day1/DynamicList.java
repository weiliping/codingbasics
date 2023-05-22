package com.datastructure.day1;

public class DynamicList<T> {
    private static int eSize;
    private Object[] objects;

    /**
     * @param capacity
     */
    public DynamicList(int capacity) {
        objects = new Object[capacity];
    }

    public DynamicList() {
        this(16);
    }

    private void resize(int size) {
        Object[] newArray = new Object[size];
        for (int i = 0; i < eSize; i++) {
            newArray[i] = objects[i];
        }
        objects = newArray;
    }

    public void add(int index, T el) {
        if (index < 0 || index > eSize) {
            return;
        }

        if (eSize >= objects.length) {
            resize(2 * eSize);
        }

        for (int i = eSize - 1; i >= index; i--) {
            objects[i + 1] = objects[i];
        }
        objects[index] = el;
        eSize++;
    }

    public void update(int index, T el) {
        if (index < 0 || index > eSize) {
            return;
        }
        objects[index] = el;
    }

    public void delete(int index) {
        if (index < 0 || index > eSize) {
            return;
        }

        for (int i = index; i < eSize; i++) {
            objects[i] = objects[i + 1];
        }
        objects[eSize--] = null;
    }
}
