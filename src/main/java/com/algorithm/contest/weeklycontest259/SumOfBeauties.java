package com.algorithm.contest.weeklycontest259;

public class SumOfBeauties {
    public static void main(String[] args) {
        System.out.println(sumOfBeauties(new int[]{1, 2, 3}));
    }
    public static int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] mins = new int[n], maxes = new int[n];
        maxes[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxes[i] = Math.max(maxes[i - 1], nums[i]);
        }
        mins[n - 1] = nums[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            mins[j] = Math.min(mins[j + 1], nums[j]);
        }
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            if (maxes[i - 1] < nums[i] && nums[i] < mins[i + 1]) {
                cnt += 2;
                continue;
            }
            if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                cnt++;
            }
        }
        return cnt;
    }
}
