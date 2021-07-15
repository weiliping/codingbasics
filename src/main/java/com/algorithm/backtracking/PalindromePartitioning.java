package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /**
     * #131
     * https://leetcode-cn.com/problems/palindrome-partitioning
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> out = new ArrayList<>();
        helper(s, 0, res, out);
        return res;
    }

    static void helper(String s, int start, List<List<String>> res, List<String> out) {
        if (s.length() == start) {
            res.add(new ArrayList<>(out));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (!isPalindrame(sub)) {
                continue;
            }
            out.add(sub);
            helper(s, i + 1, res, out);
            out.remove(out.size() - 1);
        }
    }

    static boolean isPalindrame(String s){
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
