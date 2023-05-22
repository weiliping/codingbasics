package com.algorithm.contest.weeklycontest315;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctIntegers {
    public static void main(String[] args) {
        System.out.println(countDistinctIntegers(new int[] { 1, 13, 10, 12, 31 }));
        System.out.println(countDistinctIntegers(new int[] { 2, 2, 2 }));
    }

    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            }
            int reNum = reverseInteger(num);
            if (!set.contains(reNum)) {
                set.add(reNum);
            }
        }
        return set.size();
    }

    static int reverseInteger(int num) {
        int reNum = 0;
        while (num > 0) {
            int sub = num % 10;
            num /= 10;
            reNum = reNum * 10 + sub;
        }
        return reNum;
    }
}
