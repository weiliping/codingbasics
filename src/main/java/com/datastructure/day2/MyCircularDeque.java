package com.datastructure.day2;

public class MyCircularDeque {

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(5); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));			        // 返回 true
        System.out.println(circularDeque.insertLast(2));			        // 返回 true
//        System.out.println(circularDeque.insertFront(3));			        // 返回 true
//        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        System.out.println(circularDeque.deleteLast());			        // 返回 true
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.getRear());  				// 返回 2
//        System.out.println(circularDeque.isFull());				        // 返回 true
        circularDeque.insertFront(3);
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        circularDeque.insertFront(5);
        circularDeque.deleteFront();
        System.out.println(circularDeque.getFront());				// 返回 4
    }

    private int size;
    private int[] data;
    private int head;
    private int tail;
    private int cnt;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = k;
        head = k - 1;
        tail = 0;
        cnt = 0;
        data = new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        cnt++;
        data[head] = value;
        head = (head - 1 + size) % size;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % size;
        ++cnt;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % size;
        cnt--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail = (tail - 1 + size) % size;
        cnt--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : data[(head + 1) % size];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : data[(tail - 1 + size) % size];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return cnt == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return cnt == size;
    }
}
