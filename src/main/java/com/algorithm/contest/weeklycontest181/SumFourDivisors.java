package com.algorithm.contest.weeklycontest181;

import java.util.ArrayList;
import java.util.List;

public class SumFourDivisors {

    public static void main(String[] args) {
        SumFourDivisors s = new SumFourDivisors();
        int[] nums = new int[] { 21, 4, 7 };
        System.out.println(s.sumFourDivisors(nums));
    }
    public int sumFourDivisors(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            List<Integer> divs = divisors(num);
            if (divs == null) {
                continue;
            }
            for (int d : divs) {
                cnt += d;
            }
        }
        return cnt;
    }

    private static List<Integer> divisors(int num) {
        List<Integer> divs = new ArrayList<>();
        divs.add(1);
        int n = num / 2, i = 2;
        if (num > 1) {
            divs.add(num);
        }
        while (i < n) {
            if (num % i == 0) {
                if (!divs.contains(i)) {
                    divs.add(i);
                }
                int r = num / i;
                if (!divs.contains(r)) {
                    divs.add(r);
                }
                if (divs.size() > 4) {
                    return null;
                }
            }
            i++;
        }
        if (divs.size() != 4) {
            return null;
        }
        return divs;
    }
}
