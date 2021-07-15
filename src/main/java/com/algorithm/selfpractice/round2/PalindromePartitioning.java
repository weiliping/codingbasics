package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        List<List<String>> res = partition("aab");
        for(List<String> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }

        List<String> out = new ArrayList<>();
        helper(res, out, 0, s);
        return res;
    }

    static void helper(List<List<String>> res, List<String> out, int start, String s) {
        if (s.length() == start) {
            res.add(new ArrayList<>(out));
            return;
        }

        for (int j = start; j < s.length(); j++) {
            String sub = s.substring(start, j + 1);
            if (!isPalindrome(sub)) {
                continue;
            }
            out.add(sub);
            helper(res, out, j + 1, s);
            out.remove(out.size() - 1);
        }
    }

    static boolean isPalindrome(String s) {
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
