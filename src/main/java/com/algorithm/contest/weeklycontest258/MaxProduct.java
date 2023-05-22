package com.algorithm.contest.weeklycontest258;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProduct {

    public static void main(String[] args) {
        int n = "leetcode".length();

//        System.out.println(maxPalindrome("leetcode", 0, n - 1, 0));
//        System.out.println(maxProduct("leetcodecom"));
//        System.out.println(maxProduct("bb"));
//        System.out.println(maxProduct("accbcaxxcxx"));
        System.out.println(maxProduct("zqz"));
    }

    public static int maxProduct(String s) {
        List<Integer> inds = new ArrayList<>();
        int[] res = new int[1];
        int n = s.length();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexes.add(i);
        }
        dfs(inds, 0, s, n, res, indexes);
        return res[0];
    }

    static void dfs(List<Integer> inds, int start, String s, int n, int[] res, List<Integer> indexes) {
        List<Integer> resList = new ArrayList<>(inds);
        System.out.println(Arrays.toString(resList.toArray()));
        if (resList.size() != 0) {
            if (res[0] <= (resList.size() * (n - resList.size()))) {
                int max1 = maxPalindrome(s, 0, resList.size() - 1, 0, resList);
                List<Integer> leftInd = new ArrayList<>(indexes);
                leftInd.removeAll(resList);
                int max2 = maxPalindrome(s, 0, leftInd.size() - 1, 0, leftInd);

                int t = max1 * max2;
                if (res[0] < t) {
                    res[0] = t;
                }
            }
        }
        for (int i = start; i < n; i++) {
            inds.add(i);
            dfs(inds, i + 1, s, n, res, indexes);
            inds.remove(inds.size() - 1);
        }
    }

    static int maxPalindrome(String s, int i, int j, int pre, List<Integer> indexes) {
        if (i > j) {
            return -1;
        }
        if (i == j) {
            return pre + 1;
        }
        if (s.charAt(indexes.get(i)) == s.charAt(indexes.get(j))) {
            if (i + 1 == j) {
                return pre + 2;
            }
            return maxPalindrome(s, i + 1, j - 1, pre + 2, indexes);
        }
        return Math.max(maxPalindrome(s, i + 1, j, pre, indexes), maxPalindrome(s, i, j - 1, pre, indexes));
    }
}
