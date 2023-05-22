package com.algorithm.contest.weeklycontest172;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintVertically {
    public static void main(String[] args) {
        PrintVertically p = new PrintVertically();
        System.out.println(Arrays.toString(p.printVertically("HOW ARE YOU").toArray()));
        System.out.println(Arrays.toString(p.printVertically("TO BE OR NOT TO BE").toArray()));
        System.out.println(Arrays.toString(p.printVertically("CONTEST IS COMING").toArray()));
    }
    public List<String> printVertically(String s) {
        String[] strs = s.split(" ");
        int n = strs.length, m = maxLen(strs, 0, n - 1);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (strs[j].length() <= i) {
                    sb.append(' ');
                } else {
                    sb.append(strs[j].charAt(i));
                }
            }
            int k = 0;
            while (k < sb.length()) {
                if (sb.charAt(sb.length() - k - 1) == ' ') {
                    k++;
                    continue;
                }
                break;
            }
            sb.setLength(sb.length() - k);
            res.add(sb.toString());
        }
        return res;
    }

    static int maxLen(String[] strs, int i, int j) {
        if (i > j) {
            return Integer.MIN_VALUE;
        }

        if (i == j) {
            return strs[i].length();
        }
        if (i + 1 == j) {
            return Math.max(strs[i].length(), strs[j].length());
        }
        int mid = i + ((j - i) >> 1);
        return Math.max(maxLen(strs, i, mid), maxLen(strs, mid + 1, j));
    }
}
