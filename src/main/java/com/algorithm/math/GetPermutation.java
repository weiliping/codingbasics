package com.algorithm.math;

import java.util.LinkedList;
import java.util.List;

public class GetPermutation {
    /**
     * #60
     * https://leetcode-cn.com/problems/permutation-sequence/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new GetPermutation().getPermutation(3, 3));
        System.out.println(new GetPermutation().getPermutation(4, 9));
    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new LinkedList<>();
        long mod = 1;
        for (int i = 1; i <= n; i++) {
            mod *= i;
            nums.add(i);
        }
        k--;
        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            int currInd = (int) (k / mod);
            k = (int) (k % mod);
            sb.append(String.valueOf(nums.get(currInd)));
            nums.remove(currInd);
        }
        return sb.toString();
    }
}
