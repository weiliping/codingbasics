package com.algorithm.contest.weeklycontest440;

/**
 * https://leetcode.cn/problems/fruits-into-baskets-iii/description/
 * 3479. 将水果装入篮子 III
 */
public class NumOfUnplacedFruitsII {
    public static void main(String[] args) {
        int[] fruits = new int[]{3, 4, 5};
        int[] baskets = new int[]{3, 5, 4};
        NumOfUnplacedFruitsII s = new NumOfUnplacedFruitsII();
        System.out.println(s.numOfUnplacedFruits(fruits, baskets));
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        SegmentTree segTree = new SegmentTree(baskets);
        for (int f : fruits) {
            int i = segTree.findFirst(f);
            if (i == -1) {
                ans++;
                continue;
            }
            segTree.update(i, -1);
        }
        return ans;
    }
}

class SegmentTree {
    private final int size;
    private final int[] tree;

    public SegmentTree(int[] nums) {
        this.size = nums.length;
        tree = new int[this.size << 2];
        build(nums, 0, 0, this.size - 1);
    }

    private void build(int[] nums, int node, int l, int r) {
        if (l > r) {
            return;
        }
        if (l == r) {
            this.tree[node] = nums[l];
            return;
        }

        int mid = l + ((r - l) >> 1);
        int cInd = node << 1;
        int leftChild = cInd + 1;
        int rightChild = cInd + 2;

        build(nums, leftChild, l, mid);
        build(nums, rightChild, mid + 1, r);
        this.tree[node] = Math.max(this.tree[leftChild], this.tree[rightChild]);
    }

    public void update(int idx, int val) {
        update(0, idx, val, 0, this.size - 1);
    }

    private void update(int node, int idx, int val, int l, int r) {
        if (l == idx && idx == r) {
            this.tree[node] = val;
            return;
        }

        int mid = l + ((r - l) >> 1);
        int cInds = node << 1;
        int leftChild = cInds + 1;
        int rightChild = leftChild + 1;
        if (idx <= mid) {
            update(leftChild, idx, val, l, mid);
        } else {
            update(rightChild, idx, val, mid + 1, r);
        }
        this.tree[node] = Math.max(this.tree[leftChild], this.tree[rightChild]);
    }

    public int findFirst(int target) {
        return findFirst(0, target, 0, this.size - 1);
    }

    public int findFirst(int node, int target, int l, int r) {
        if (this.tree[node] < target) {
            return -1;
        }
        if (l == r) {
            return l;
        }
        int mid = l + ((r - l) >> 1);
        int cInds = node << 1;
        int leftChild = cInds + 1;
        int rightChild = leftChild + 1;

        int ind = findFirst(leftChild, target, l, mid);
        if (ind == -1) {
            return findFirst(rightChild, target, mid + 1, r);
        }
        return ind;
    }
}
