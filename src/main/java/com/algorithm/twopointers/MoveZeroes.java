package com.algorithm.twopointers;

public class MoveZeroes {
    /**
     * #283
     * https://leetcode-cn.com/problems/move-zeroes/
     *
     * @param args
     */
    public static void main(String[] args) {
        moveZeroesI(new int[] { 0, 1, 0, 3, 12 });
        moveZeroes(new int[] { 0, 1, 0, 3, 12 });
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, zeroCnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int j = i;
                while (j < n - 1 - zeroCnt) {
                    nums[j] = nums[j + 1];
                    j++;
                }
                nums[n - 1 - zeroCnt] = 0;
                zeroCnt++;
            }
        }
    }

    public static void moveZeroesI(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; ) {
            if (nums[i] != 0) {
                int buffer = nums[i];
                nums[i] = 0;
                nums[j] = buffer;
                j++;
            }
            i++;
        }
    }
}
