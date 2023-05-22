package com.algorithm.contest.weeklycontest187;

public class KLengthApart {
    public static void main(String[] args) {
        int nums[] = new int[] { 1, 0, 0, 0, 1, 0, 0, 1 }, k = 2;
        KLengthApart kl = new KLengthApart();
        System.out.println(kl.kLengthApart(nums, k));
    }

    public boolean kLengthApart(int[] nums, int k) {
        int pre = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (pre == -1 || pre + k + 1 <= i) {
                    pre = i;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
