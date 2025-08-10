package com.datastructure;

public class BinaryIndexedTree {

    private final int[] tree;
    private final int size;
    public BinaryIndexedTree(int n) {
        this.size = n + 1;
        this.tree = new int[this.size]; // 1-based index
    }

    public void add(int idx, int val) {
        for (int i = idx; i < this.size; i += lowbit(i)) {
            tree[i] += val;
        }
    }
    
    public int query(int idx) {
        int sum = 0;
        for (int i = idx; i > 0; i -= lowbit(i)) {
            sum += tree[i];
        }
        return sum;
    }

    private int lowbit(int x) {
        return x & -x;
    }
}
