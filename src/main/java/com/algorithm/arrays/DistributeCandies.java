package com.algorithm.arrays;

import java.util.HashSet;

public class DistributeCandies {

    /**
     * #575
     * https://leetcode-cn.com/problems/distribute-candies
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[] { 1, 1, 2, 3 }));
    }

    public static int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        HashSet<Integer> s = new HashSet<>();
        for (int c : candies) {
            s.add(c);
        }
        return Math.min(s.size(), candies.length / 2);
    }
}
