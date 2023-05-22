package com.algorithm.contest.weeklycontest197;

public class NumSub {

    /**
     * https://leetcode-cn.com/problems/path-with-maximum-probability/
     * @param args
     */
    public static void main(String[] args) {
        NumSub n = new NumSub();
        System.out.println(n.numSub("0110111"));
        System.out.println(n.numSub("101"));
        System.out.println(n.numSub("111111"));
        System.out.println(n.numSub("000"));
//        System.out.println(n.numSub(args[0]));
        //200542505
    }
    static final int MOD = (int) 1e9 + 7;
    public int numSub(String s) {
        char chrs[] = s.toCharArray();
        long cnt = 0, ans = 0;
        for (char c : chrs) {
            if (c == '1') {
                cnt++;
                continue;
            }
            if (cnt > 0) {
                ans += (cnt + 1) * cnt / 2;
                cnt = 0;
            }
        }
        if (cnt > 0) {
            ans += (cnt + 1) * cnt / 2;
        }
        return (int) (ans % MOD);
    }
}
