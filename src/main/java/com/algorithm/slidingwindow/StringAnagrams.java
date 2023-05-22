package com.algorithm.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagrams {
    /**
     * #438
     * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findAnagrams("cbaebabacd", "abc").toArray()));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
        int[] hash = new int[256]; //character hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }

            if (count == 0) {
                list.add(left);
            }

            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return list;
    }
}
