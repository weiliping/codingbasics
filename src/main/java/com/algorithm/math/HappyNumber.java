package com.algorithm.math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    /**
     * #202
     * https://leetcode-cn.com/problems/happy-number/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while (true) {
            int t = trans(n);
            if (t == 1) {
                return true;
            }
            if (s.contains(t)) {
                return false;
            }
            s.add(t);
            n = t;
        }
    }

    static int trans(int n) {
        int s = 0;
        while (n > 0) {
            int t = n % 10;
            s += t * t;
            n = n / 10;
        }
        return s;
    }
}
