package com.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveInvalidParentheses {

    /**
     * #301
     * https://leetcode-cn.com/problems/remove-invalid-parentheses
     * @param args
     */
    public static void main(String[] args) {
//        String s = "()())()";
//        String s = "(a)())()";
//        String s = ")(";
        String s = "()(";
//        String s = ")(f";
        System.out.println(Arrays.toString(removeInvalidParentheses(s).toArray()));
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        int[] duplicateNum = countDuplicatedNum(s);
        int left = duplicateNum[0], right = duplicateNum[1];
        if (left + right == s.length()) {
            res.add("");
            return res;
        }
        HashSet<String> uniqueRes = new HashSet<>();
        List<Integer> outInt = new ArrayList<>();
        dfs(s, 0, left, right, uniqueRes, outInt);
        return new ArrayList<>(uniqueRes);
    }

    static void dfs(String s, int start, int left, int right, HashSet<String> res, List<Integer> outInt) {
        if (left == 0 && right == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (!outInt.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            String subRes = sb.toString();
            int[] counts = countDuplicatedNum(subRes);
            if (counts[1] == 0 && counts[0] == 0) {
                res.add(sb.toString());
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' && left > 0) {
                left--;
                outInt.add(i);
                dfs(s, i + 1, left, right, res, outInt);
                outInt.remove(outInt.size() - 1);
                left++;
            }
            if (ch == ')' && right > 0) {
                right--;
                outInt.add(i);
                dfs(s,  i + 1, left, right, res, outInt);
                outInt.remove(outInt.size() - 1);
                right++;
            }
        }
    }

    static int[] countDuplicatedNum(String s) {
        int i = 0, n = s.length(), left = 0, right = 0;
        while (i < n) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
            i++;
        }
        return new int[] { left, right };
    }
}
