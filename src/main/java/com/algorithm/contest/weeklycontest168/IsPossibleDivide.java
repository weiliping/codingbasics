package com.algorithm.contest.weeklycontest168;

import java.util.TreeMap;

public class IsPossibleDivide {
    public static void main(String[] args) {
        IsPossibleDivide is = new IsPossibleDivide();
//        System.out.println(is.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
//        System.out.println(is.isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
//        System.out.println(is.isPossibleDivide(new int[]{3,3,2,2,1,1}, 3));
//        System.out.println(is.isPossibleDivide(new int[]{1,2,3,4}, 3));
        System.out.println(is.isPossibleDivide(new int[]{10,11,12,16,17,18,8,9,10,13,14,12}, 3));

    }
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }
        int len = n / k;
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        while (len > 0) {
            int i = mp.firstKey();
            int j = k;
            while (j > 0) {
                Integer v = mp.get(i);
                if (v == null) {
                    return false;
                }
                if (v == 1) {
                    mp.remove(i);
                } else {
                    mp.put(i, v - 1);
                }
                i++;
                j--;
            }
            len--;
        }
        return true;
    }
}
