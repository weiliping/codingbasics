package com.algorithm.contest.weeklycontest176;

public class ProductOfNumbers {
    int[] nums;
    int currPos;
    public ProductOfNumbers() {
        currPos = -1;
        nums = new int[40000];
    }

    public void add(int num) {
        currPos++;
        nums[currPos] = num;
    }

    public int getProduct(int k) {
        int pro = 1;
        for (int i = 0; i < k; i++) {
            int ind = currPos - i;
            if (nums[ind] == 0) {
                return 0;
            }
            pro *= nums[ind];
        }
        return pro;
    }
}
