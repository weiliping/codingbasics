package com.algorithm.contest.weeklycontest261;

public class MinimumMoves {
    public static void main(String[] args) {
        System.out.println(minimumMoves("XXX"));
        System.out.println(minimumMoves("OXOX"));
        System.out.println(minimumMoves("OOOO"));
        System.out.println(minimumMoves("XXOX"));
    }
    public static int minimumMoves(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'O') {
                continue;
            }
            ans++;
            i += 2;
        }
        return ans;
    }
}
