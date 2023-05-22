package com.algorithm.contest.weeklycontest161;

public class MinimumSwap {

    public static void main(String[] args) {
        MinimumSwap m = new MinimumSwap();
        System.out.println(m.minimumSwap("xy", "yx"));
        System.out.println(m.minimumSwap("xx", "xy"));
        System.out.println(m.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
    public int minimumSwap(String s1, String s2) {
        char[] chrs1 = s1.toCharArray(), chrs2 = s2.toCharArray();
        int n = chrs1.length;
        int[] cnts1 = new int[2], cnts2 = new int[2];

        for (int i = 0; i < n; i++) {
            if (chrs1[i] == chrs2[i]) {
                continue;
            }
            cnts1[chrs1[i] - 'x']++;
            cnts2[chrs2[i] - 'x']++;
        }
        int t = cnts1[0] + cnts1[1];
        if (t % 2 != 0 || (cnts1[0] != cnts2[1] || cnts2[0] != cnts1[1])) {
            return -1;
        }

        int ans = 0;
        ans += Math.min((cnts1[0] >> 1), (cnts2[1] >> 1));
        ans += Math.min((cnts1[1] >> 1), (cnts2[0] >> 1));
        if ((cnts1[0] & 1) == 1) {
            ans += 2;
        }
        return ans;
    }
}
