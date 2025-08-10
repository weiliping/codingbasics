package com.datastructure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FenwickTree {

    public static void main(String[] args) {
        FenwickTree fenwickTree = new FenwickTree(10);
        // fenwickTree.add(1, 5);
        // fenwickTree.add(2, 3);
        // fenwickTree.add(3, 7);
        // fenwickTree.add(4, 8);
        // fenwickTree.add(5, 9);
        // fenwickTree.add(6, 10);
        // fenwickTree.add(7, 11);
        // fenwickTree.add(8, 12);
        // fenwickTree.add(9, 13);
        // System.out.println(Arrays.toString(fenwickTree.tree));
        for (int i = 3; i > 0; i -= fenwickTree.lowbit(i)) {
            System.out.println(i);
        }
        // System.out.println(fenwickTree.query(3)); // Output: 15
        // System.out.println(fenwickTree.query(2)); // Output: 8
    }
    private final int[] tree;

    public FenwickTree(int n) {
        this.tree = new int[n];
    }

    public void add(int idx, int val) {
        for (int i = idx; i < tree.length; i += lowbit(i)) {
            System.out.println(i + " " + val);
            tree[i] += val;
        }
        System.out.println("-------------------");
    }

    public int query(int idx) {
        int sum = 0;
        for (int i = idx; i > 0; i -= lowbit(i)) {
            sum += tree[i];
        }
        return sum;
    }

    public int lowbit(int x) {
        return x & -x;
    }
}
