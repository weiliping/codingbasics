package com.algorithm.contest.weeklycontest156;

public class EqualSubstring {
    public static void main(String[] args) {
        EqualSubstring e = new EqualSubstring();
        String s = "krrgw", t = "zjxss";
        int maxCost = 19;
        System.out.println(e.equalSubstring(s, t, maxCost));

        String s1 = "abcd", t1 = "bcdf";
        int maxCost1 = 3;
        System.out.println(e.equalSubstring(s1, t1, maxCost1));

        String s2 = "abcd", t2 = "cdef";
        int maxCost2 = 3;
        System.out.println(e.equalSubstring(s2, t2, maxCost2));

        String s3 = "abcd", t3 = "acde";
        int maxCost3 = 0;
        System.out.println(e.equalSubstring(s3, t3, maxCost3));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int cnt = 0, n = s.length();
        char[] chrs = s.toCharArray(), chrt = t.toCharArray();
        int l = 0, r = 0, cost = 0;
        for (; r < n; r++) {
            cost += Math.abs(chrs[r] - chrt[r]);
            if (cost <= maxCost) {
                cnt = Math.max(cnt, r - l + 1);
            }
            while (cost > maxCost) {
                cost -= Math.abs(chrs[l] - chrt[l]);
                l++;
            }
        }
        return cnt;
    }
}
