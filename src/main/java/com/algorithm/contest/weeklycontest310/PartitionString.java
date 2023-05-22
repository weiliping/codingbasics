package com.algorithm.contest.weeklycontest310;

import java.util.Arrays;

public class PartitionString {
    public static void main(String[] args) {
        System.out.println(partitionString("abacaba"));
        System.out.println(partitionString("ssssss"));
    }

    public static int partitionString(String s) {
        boolean[] cnts = new boolean[26];
        char[] chars = s.toCharArray();
        int cnt = 1, n = chars.length;
        for (int i = 0; i < n; i++) {
            int ind = chars[i] - 'a';
            if (!cnts[ind]) {
                cnts[ind] = true;
                continue;
            }
            cnt++;
            Arrays.fill(cnts, false);
            cnts[ind] = true;
        }
        return cnt;
    }
}
