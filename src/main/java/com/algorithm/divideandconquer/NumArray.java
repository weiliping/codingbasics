package com.algorithm.divideandconquer;

public class NumArray {

    /**
     * #307
     * https://leetcode-cn.com/problems/range-sum-query-mutable/
     *
     * @param args
     */
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[] {1, 3, 5, 7});
        System.out.println(obj.sumRange(1, 3));
        obj.update(2, 2);
        System.out.println(obj.sumRange(1, 3));
    }

    private int n;
    private int tree[];
    public NumArray(int[] nums) {
        if (nums != null) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    void buildTree(int nums[]) {
        for (int i = n; i < n * 2; i++) {
            tree[i] = nums[i - n];
        }
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    void update(int i, int val) {
        tree[i += n] = val;

        while (i > 0) {
            tree[i / 2] = tree[i] + tree[i ^ 1];
            i /= 2;
        }
    }

    int sumRange(int i, int j) {
        int sum = 0;
        for (i += n, j += n; i <= j; i /= 2, j /= 2) {

            if ((i & 1) == 1) {
                sum += tree[i++];
            }
            if ((j & 1) == 0) {
                sum += tree[j--];
            }
        }
        return sum;
    }
}
