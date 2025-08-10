package com.algorithm.contest.biweeklycontest144;

public class ShiftDistance {
    public static void main(String[] args) {
        int[] nextCost = new int[]{100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] previousCost = new int[]{1,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String s = "abab";
        String t = "baba";
        ShiftDistance sd = new ShiftDistance();
        System.out.println(sd.shiftDistance(s, t, nextCost, previousCost));
    }
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long[] cost1 = new long[27];
        for (int i = 0; i < 26; i++) {
            cost1[i + 1] = cost1[i] + nextCost[i];
        }
        long[] cost2 = new long[27];
        for (int i = 25; i >= 0; i--) {
            cost2[i] = cost2[i + 1] + previousCost[i];
        }
        long ans = 0;
        int n = s.length();
        for (int k = 0; k < n; k++) {
            char c1 = s.charAt(k);
            char c2 = t.charAt(k);
            if (c1 == c2) {
                continue;
            }
            int i = c1 - 'a';
            int j = c2 - 'a';
            ans += Math.min(getNextV(i, j, cost1), getPreV(i, j, cost2));
        }
        return ans;
    }

    private long getNextV(int i, int j, long[] v) {
        if (i < j) {
            return v[j] - v[i]; 
        }
        return v[26] - v[i] + v[j];
    }
    private long getPreV(int i, int j, long[] v) {
        if (i > j) {
            return v[j + 1] - v[i + 1];
        }
        return v[0] - v[i + 1] + v[j + 1];
    }    
}
