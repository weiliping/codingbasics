package com.algorithm.contest.weeklycontest315;

import java.util.Arrays;

public class SumOfNumberAndReverse {
    public static void main(String[] args) {
        // System.out.println(sumOfNumberAndReverse(443)); // true
        // System.out.println(sumOfNumberAndReverse(63)); //false
        // System.out.println(sumOfNumberAndReverse(181)); //true
        // System.out.println(sumOfNumberAndReverse(14423)); //false
        // System.out.println(sumOfNumberAndReverse(14223)); //true
        // System.out.println(sumOfNumberAndReverse(31413)); //true
        // System.out.println(sumOfNumberAndReverse(0)); // true
        // System.out.println(sumOfNumberAndReverse(100)); // false
        // System.out.println(sumOfNumberAndReverse(144)); // false
        // System.out.println(sumOfNumberAndReverse(1291)); // true
        System.out.println(sumOfNumberAndReverse(99988)); // true
        // for (int i = 1; i < 100000; i++) {
        // System.out.print("i = " + i + " ");
        // System.out.println(sumOfNumberAndReverse(i));
        // }
    }

    public static boolean sumOfNumberAndReverse(int num) {
        if (num == 0) {
            return true;
        }
        int[] nums = new int[6];
        Arrays.fill(nums, -1);
        int i = 5;
        while (num > 0) {
            nums[i] = num % 10;
            num /= 10;
            i--;
        }
        return dfs(i + 1, 5, nums, 0, 0);
    }

    static boolean dfs(int i, int j, int[] nums, int x, int y) {
        if (i == j) {
            if (nums[i] - x < 0) {
                return false;
            }
            return ((nums[j] - y) & 1) == 0;
        }
        if (i + 1 == j) {
            if (nums[i] - x < 0 || nums[i] - y < 0) {
                return false;
            }
            if (nums[i] - x == nums[j] - y) {
                return true;
            }
            if (nums[i] == 1) {
                return dfs(i + 1, j, nums, 0, 0);
            }
            return false;
        }

        if (nums[i] - x == nums[j] - y) {
            if (nums[i] != 1) {
                return dfs(i + 1, j - 1, nums, 0, x);
            }
            boolean f = dfs(i + 1, j - 1, nums, 0, x);
            if (f) {
                return f;
            }
            if (i + 1 < j && nums[i + 1] - 1 == nums[j]) {
                if (i + 2 == j) {
                    return true;
                }
                return dfs(i + 2, j - 1, nums, 0, 1);
            }
        }

        if (nums[i] - 1 == nums[j]) {
            return dfs(i + 1, j - 1, nums, 1, 0);
        }

        if (nums[i] == 1 && i + 1 < j && nums[i + 1] - 1 == nums[j]) {
            if (i + 2 == j) {
                return true;
            }
            return dfs(i + 2, j - 1, nums, 1, 1);
        }
        return false;
    }
}
