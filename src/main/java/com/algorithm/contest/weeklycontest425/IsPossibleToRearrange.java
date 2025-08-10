package com.algorithm.contest.weeklycontest425;

import java.util.HashMap;
import java.util.Map;

public class IsPossibleToRearrange {
    public static void main(String[] args) {
        System.out.println(isPossibleToRearrange("aabbcc", "bbaacc", 3));
        System.out.println(10>>1);    
        System.out.println(11>>1);    
    }
    public static boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        int[] cnts = new int[26*26*26];
        int n = s.length();
        char[] chrs1 = s.toCharArray();
        char[] chrs2 = t.toCharArray();
        k = n / k;
        for (int i = 0; i < n; i += k) {
            int ind = 0;
            for (int j = 0; j < k; j++) {
                ind = ind * 26 + (int)(chrs2[i + j] - 'a');
            }
            cnts[ind]++;
        }
        for (int i = 0; i < n; i += k) {
            int ind = 0;
            for (int j = 0; j < k; j++) {
                ind = ind * 26 + (chrs1[i + j] - 'a');
            }
            if (cnts[ind] == 0) {
                return false;
            }
            cnts[ind]--;
        }
        return true;
    }
}
