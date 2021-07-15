package com.algorithm.stacksandqueues;

class Elem {
    public int val;
    public int min;
    public Elem next;

    public Elem(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

public class MinStack {
    /**
     * https://leetcode-cn.com/problems/min-stack/
     *
     * @param args
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        System.out.println(minStack.getMin() == -3);
        minStack.pop();
        minStack.top();
        System.out.println(minStack.getMin() == -2);
    }

    private Elem top;

    public MinStack() {
    }

    public void push(int x) {
        if (top == null) {
            top = new Elem(x, x);
            return;
        }
        Elem e = new Elem(x, Math.min(x, top.min));
        e.next = top;
        top = e;
    }

    public void pop() {
        if (top != null) {
            Elem next = top.next;
            top.next = null;
            top = next;
        }
    }

    public int top() {
        if (top == null) {
            return -1;
        }
        return top.val;
    }

    public int getMin() {
        if (top == null) {
            return -1;
        }
        return top.min;
    }
}
