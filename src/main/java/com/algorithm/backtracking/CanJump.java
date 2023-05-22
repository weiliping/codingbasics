package com.algorithm.backtracking;

public class CanJump {

    /**
     * #55
     * https://leetcode-cn.com/problems/jump-game/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[] { 3, 2, 1, 0, 4 }));
    }

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int n = nums.length, reach = 0;
        for (int i = 0; i < n; i++) {
            if (i > reach || reach >= n - 1) {
                break;
            }
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= n - 1;
    }
}
