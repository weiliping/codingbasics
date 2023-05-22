package com.algorithm.contest.weeklycontest252;

import java.util.HashSet;
import java.util.Set;

public class IsThree {
    public static void main(String[] args) {
        IsThree is = new IsThree();
        System.out.println(is.isThree(4));
    }
    public boolean isThree(int n) {
        int m = (int) Math.sqrt((double)n);
        Set<Integer> s = new HashSet<>();
        int j = 1;
        while (j <= m) {
            if (n % j == 0) {
                s.add(j);
                s.add(n / j);
            }
            j++;
        }
        return s.size() == 3;
    }
}
