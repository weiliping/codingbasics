package com.algorithm.contest.weeklycontest160;

import java.util.Arrays;
import java.util.List;

public class MaxLength {

    public static void main(String[] args) {
//        System.out.println(maxLength(Arrays.asList("un","iq","ue")));
//        System.out.println(maxLength(Arrays.asList("cha","r","act","ers")));
//        System.out.println(maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
//        System.out.println(maxLength(Arrays.asList("yy","bkhwmpbiisbldzknpm")));
        System.out.println(maxLength(Arrays.asList("okeufp","nywphwagxldoqy","xyebrntjltqmgjxnb","rbchuiwplpgphagpairkxopkcj","fyicivb","mpvgvrbkpzoqlkx","aoimxirdq","rzwzkevuwt","smtznhfrk","bboeriyuqex")));
    }
    static final int MAX_RES = 26;
    public static int maxLength(List<String> arr) {
        int n = arr.size(), m = 1 << n;
        int[][] cnts = new int[m][27];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int len = 1 << i;
            int[] curr = new int[27];
            boolean isValid = true;
            for (char ch : arr.get(i).toCharArray()) {
                if (curr[ch - 'a'] > 0) {
                    isValid = false;
                    break;
                }
                curr[ch - 'a']++;
            }
            if (!isValid) {
                continue;
            }
            curr[26] = arr.get(i).length();
            if (curr[26] == MAX_RES) {
                return MAX_RES;
            }

            for (int j = 0; j < len; j++) {
                int[] mer = new int[27];
                int k = 0;
                for (; k < 26; k++) {
                    if (cnts[j][k] == 0 || curr[k] == 0) {
                        mer[k] = cnts[j][k] + curr[k];
                        continue;
                    }
                    break;
                }
                if (k != 26) {
                    if (cnts[j][26] > curr[26]) {
                        cnts[j | len] = cnts[j];
                    } else {
                        cnts[j | len] = curr;
                        if (ans < curr[26]) {
                            ans = curr[26];
                        }
                    }
                    continue;
                }
                mer[26] = cnts[j][26] + curr[26];
                if (ans < mer[26]) {
                    ans = mer[26];
                    if (ans == MAX_RES) {
                        return ans;
                    }
                }
                cnts[j | len] = mer;
            }
        }
        return ans;
    }
}
