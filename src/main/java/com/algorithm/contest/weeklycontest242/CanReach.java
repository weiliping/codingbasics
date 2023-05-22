package com.algorithm.contest.weeklycontest242;

import java.util.ArrayDeque;

public class CanReach {

    public static void main(String[] args) {
        CanReach c = new CanReach();
//        System.out.println(c.canReach("011010", 2,3));
//        System.out.println(c.canReach("01101110", 2,3));
//        System.out.println(c.canReach("00111010", 3,5));
//        System.out.println(c.canReach("00", 1,1));
        System.out.println(c.canReachI("00", 1,1));
//        System.out.println(c.canReach(args[0], 1,99999));
//        System.out.println(c.canReach("0000000000", 8,8));
    }
    public boolean canReachI(String s, int minJump, int maxJump) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;

        boolean[] dp = new boolean[n];
        int[] zeroCnts = new int[n];

        for (int i = 0; i < minJump; i++) {
            zeroCnts[i] = 1;
        }

        for (int i = minJump; i < n; i++) {
            int l = i - maxJump, r = i - minJump;
            int total = zeroCnts[r];
            if (l > 0) {
                total -= zeroCnts[l - 1];
            }
            if (chrs[i] == '0') {
                dp[i] = (total != 0);
            }
            zeroCnts[i] = zeroCnts[i - 1] + (dp[i] ? 1 : 0);
        }
        return dp[n - 1];
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        if (chrs[n - 1] != '0') {
            return false;
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { minJump, maxJump });
        int i = 0;
        while (!q.isEmpty()) {
            while (!q.isEmpty() && q.peek()[1] < i) {
                q.poll();
            }
            if (q.isEmpty()) {
                return false;
            }
            int[] t = q.poll();

            for (i = Math.max(i, t[0]); i <= t[1]; i++) {
                if (chrs[i] == '0') {
                    if (i + minJump <= n - 1) {
                        if (i + maxJump >= n - 1) {
                            return true;
                        }
                        q.offer(new int[] {i + minJump, i + maxJump});
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }
}
