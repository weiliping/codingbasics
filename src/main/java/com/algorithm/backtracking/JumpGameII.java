package com.algorithm.backtracking;

public class JumpGameII {

    /**
     * #45
     * https://leetcode-cn.com/problems/jump-game-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(jump(new int[] { 2, 3, 1, 1, 4 }));
    }

    public static int jump(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length, res = 0, cur = 0, last = 0;
        for (int i = 0; i < n; i++) {
            if (i > last) {
                res++;
                last = cur;
                if (cur >= n - 1) {
                    return res;
                }
            }
            cur = Math.max(cur, i + nums[i]);
        }
        return res;
    }
}
