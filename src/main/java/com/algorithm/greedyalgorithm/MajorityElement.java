package com.algorithm.greedyalgorithm;

public class MajorityElement {

    /**
     * #169
     * https://leetcode-cn.com/problems/majority-element
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(majorityElementII(new int[] { 1, 3, 1, 3, 1, 3, 2, 3, 1, 3}));
    }

    public static int majorityElement(int[] nums) {
        int res = 0, cnt = 0;

        for (int num : nums) {
            if (cnt == 0) {
                res = num;
                cnt++;
            } else {
                if (res == num) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        return res;
    }

    public static int majorityElementII(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; i++) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) {
                    break;
                }
                if ((num & (1 << i)) != 0) {
                    ++ones;
                } else {
                    ++zeros;
                }
            }
            if (ones > zeros) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
