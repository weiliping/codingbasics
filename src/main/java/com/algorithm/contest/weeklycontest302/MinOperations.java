package com.algorithm.contest.weeklycontest302;

import java.util.TreeMap;

public class MinOperations {
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 2, 4, 3 }, numsDivide = new int[] { 9, 6, 9, 3, 15 };
        System.out.println(minOperations(nums, numsDivide));

        int[] nums1 = new int[] { 4, 3, 6 }, numsDivide1 = new int[] { 8, 2, 6, 10 };
        System.out.println(minOperations(nums1, numsDivide1));
    }

    public static int minOperations(int[] nums, int[] numsDivide) {
        int n = numsDivide.length;
        int divNum = numsDivide[0];
        for (int i = 1; i < n; i++) {
            divNum = numsDivide[i] > divNum ? gcd(numsDivide[i], divNum) : gcd(divNum, numsDivide[i]);
            if (divNum == 1) {
                break;
            }
        }

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Integer k : mp.keySet()) {
            if (divNum % k == 0) {
                return res;
            }
            res += mp.get(k);
        }
        return -1;
    }

    static int gcd(int i, int j) {
        int r = i % j;
        if (r == 0) {
            return j;
        }
        return gcd(j, r);
    }
}
