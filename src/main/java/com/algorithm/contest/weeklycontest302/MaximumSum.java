package com.algorithm.contest.weeklycontest302;

public class MaximumSum {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[] { 18, 43, 36, 13, 7 }));
        System.out.println(maximumSum(new int[] { 10, 12, 19, 14 }));
        System.out.println(maximumSum(new int[] { 229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93,
                147, 50, 347, 210, 251, 366, 401 }));
    }

    public static int maximumSum(int[] nums) {
        int[] sums = new int[82];
        int max = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            int s = countSum(nums[i]);
            if (sums[s] > 0) {
                int sub = sums[s] + nums[i];
                if (max < sub) {
                    max = sub;
                }
            }
            if (sums[s] < nums[i]) {
                sums[s] = nums[i];
            }
        }
        return max;
    }

    static int countSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
