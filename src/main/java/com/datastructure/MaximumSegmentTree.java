package com.datastructure;

public class MaximumSegmentTree {
    private final int[] tree;
    private final int size;
    public MaximumSegmentTree(int[] nums) {
        this.size = nums.length;
        this.tree = new int[this.size * 4];
        build(nums, 0, 0, this.size - 1);
    }

    public void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            build(nums, node * 2 + 1, start, mid);
            build(nums, node * 2 + 2, mid + 1, end);
            tree[node] = Math.max(tree[node * 2 + 1], tree[node * 2 + 2]);
        }
    }

    public void update(int idx, int val, int node, int start, int end) {
        if (start > end) {
            return;
        }
        if (idx == start && idx == end) {
            tree[node] = val;
            return;
        } 
        int mid = start + (end - start) / 2;
        int leftChild = node * 2 + 1;
        int rightChild = node * 2 + 2;
        if (idx <= mid) {
            update(idx, val, leftChild, start, mid);
        } else {
            update(idx, val, rightChild, mid + 1, end);
        }
        tree[node] = Math.max(tree[leftChild], tree[rightChild]);
    }
}
