package com.algorithm.contest.weeklycontest445;

import java.util.LinkedList;
import java.util.List;

public class SmallestPalindromeII {
    public static void main(String[] args) {
        SmallestPalindromeII sp = new SmallestPalindromeII();
        String s = "aa";
        int k = 2;
        System.out.println(sp.smallestPalindrome(s, k));
    }
    public String smallestPalindrome(String s, int k) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        int h = (n >> 1);
        int[] cnts = new int[26];
        for (int i = 0; i < h; i++) {
            cnts[chrs[i] - 'a']++;
        }

        int i = 0;
        long mod = 1;
        List<Integer> list = new LinkedList<>();
        for (int j = 0; j < 26; j++) {
            while (cnts[j] > 0) {
                cnts[j]--;
                chrs[i] = (char) (j + 'a');
                i++;
                list.add(i);
                mod *= i;
            }
        }
        if (k > mod) {
            return "";
        }
        k--;
        for (int j = 0; j < h; j++) {
            mod = mod / (h - j);
            int currInd = (int) (k / mod);
            k = (int) (k % mod);
            chrs[j] = list.get(currInd);
            list.remove(currInd);
        }
        for (int j = 0; j < h; j++) {
            chrs[n - j - 1] = chrs[j];
        }
        return String.valueOf(chrs);
    }
}
