package com.algorithm.contest.weeklycontest251;

public class GetLucky {
    public static void main(String[] args) {
        GetLucky g = new GetLucky();

        System.out.println(g.getLucky("zbax", 2));
        System.out.println(g.getLucky("iiii", 1));
        System.out.println(g.getLucky("leetcode", 2));
    }

    public int getLucky(String s, int k) {
        char[] chrs = s.toCharArray();
        int res = 0;
        for (char c : chrs) {
            int num = c - 96;
            while (num > 0) {
                res += num % 10;
                num /= 10 ;
            }
        }

        if (k == 1 || res < 10) {
            return res;
        }

        while (k > 1) {
            int t = res;
            res = 0;
            while (t > 0) {
                res += t % 10;
                t /= 10;
            }
            if (res < 10) {
                return res;
            }
            k--;
        }
        return res;
    }
}
