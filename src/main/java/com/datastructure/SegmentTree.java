package com.datastructure;

import java.util.Arrays;

public class SegmentTree {
    public int[] segmentTree;
    public int n;
    public int[] nums;
    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.segmentTree = new int[n * 4];
        build(0, 0, n - 1);
    }

    public static void main(String[] args) {
        SegmentTree seg = new SegmentTree(new int[] {3, 6, 4, 8, 1, 2, 9, 5, 7, 0});
        System.out.println(Arrays.toString(seg.segmentTree));
        seg.update(7, 15);
        System.out.println(Arrays.toString(seg.segmentTree));
    }
    public void build(int i, int s, int e) {
        if (s == e) {
            segmentTree[i] = nums[s];
            return;
        }
        int m = s + ((e - s) >> 1);
        build(i * 2 + 1, s, m);
        build(i * 2 + 2, m + 1, e);
        segmentTree[i] = segmentTree[i * 2 + 1] + segmentTree[i * 2 + 2];
    }

    public void change(int i, int v, int ind, int s, int e) {
        if (s == e) {
            segmentTree[ind] = v;
            return;
        }
        int m = s + ((e - s) >> 1);
        if (i <= m) {
            change(i, v, ind * 2 + 1, s, m);
        } else {
            change(i, v, ind * 2 + 2, m + 1, e);
        }
        segmentTree[ind] = segmentTree[ind * 2 + 1] + segmentTree[ind * 2 + 2];
    }
    public int range(int l, int r, int ind, int s, int e) {
        if (l == s && r == e) {
            return segmentTree[ind];
        }
        int m = s + ((e - s) >> 1);
        if (r <= m) {
            return range(l, r, ind * 2 + 1, s, m);
        } else if (l > m) {
            return range(l, r, ind * 2 + 2, m + 1, e);
        } else {
            return range(l, m, ind * 2 + 1, s, m) + range(m + 1, r, ind * 2 + 2, m + 1, e);
        }
    }
    public void update(int i, int v) {
        change(i, v, 0, 0, n - 1);
    }

    public int sumRange(int l, int r) {
        return range(l, r, 0, 0, n - 1);
    }
}
