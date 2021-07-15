package com.algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestDiverseString {
    public static void main(String[] args) {
//        System.out.println(longestDiverseString(1, 1, 7));
        System.out.println(longestDiverseString(2, 2, 1));
    }

    public static String longestDiverseString(int a, int b, int c) {
        Integer[][] dp = new Integer[][] {{a, 0}, {b, 1}, {c, 2}};
        StringBuilder sb = new StringBuilder();
        while(true) {
            sortDp(dp);
            char ch = toChar(dp[0][1]);
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == ch && sb.charAt(sb.length() - 2) == ch) {
                if (dp[1][0] > 0) {
                    sb.append(toChar(dp[1][1]));
                    dp[1][0]--;
                } else {
                    break;
                }
            } else {
                if (dp[0][0] > 0) {
                    sb.append(ch);
                    dp[0][0]--;
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }

    static char toChar(int i) {
        if (i == 0) {
            return 'a';
        }
        if (i == 1) {
            return 'b';
        }
        return 'c';
    }

    static void sortDp(Integer[][] dp) {
        Arrays.sort(dp, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] > o2[0] ? -1 : 1;
            }
        });
    }
}
