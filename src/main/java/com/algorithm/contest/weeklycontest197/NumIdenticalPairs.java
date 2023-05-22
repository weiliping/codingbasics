package com.algorithm.contest.weeklycontest197;

public class NumIdenticalPairs {

    /**
     * https://leetcode-cn.com/problems/number-of-good-pairs/
     * @param args
     */
    public static void main(String[] args) {
        NumIdenticalPairs n = new NumIdenticalPairs();
        System.out.println(n.numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
        System.out.println(n.numIdenticalPairs(new int[] { 1, 1, 1, 1 }));
        System.out.println(n.numIdenticalPairs(new int[] { 1, 2, 3 }));
    }
    public int numIdenticalPairs(int[] nums) {
        int[] cnts = new int[101];

        for (int num : nums) {
            cnts[num]++;
        }

        int res = 0;

        for (int c : cnts) {
            if (c == 2) {
                res++;
                continue;
            }
            if (c > 2) {
                res += combin(c, 2);
            }
        }
        return res;
    }

    static int combin(int n, int k) {
        int a = 1, b = 1;
        if (k > n / 2) {
            k = n - k;
        }
        for (int i = 1; i <= k; i++) {
            a *= (n + 1 - i);
            b *= i;
        }
        return a / b;
    }
}
