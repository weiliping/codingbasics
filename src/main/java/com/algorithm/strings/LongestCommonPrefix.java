package com.algorithm.strings;

public class LongestCommonPrefix {

    /**
     * #14
     * https://leetcode-cn.com/problems/longest-common-prefix
     *
     * @param args
     */
    public static void main(String[] args) {
        //        String[] strs = new String[] { "flower", "flow", "flight" };
        String[] strs = new String[] { "dog", "racecar", "car" };
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = commonPrefix(commonPrefix, strs[i]);
            if (commonPrefix == "") {
                break;
            }
        }
        return commonPrefix;
    }

    private String commonPrefix(String str1, String str2) {
        if (str1 == null || str1 == "" || str2 == null || str2 == "") {
            return "";
        }
        int i = 0, m = str1.length(), n = str2.length();
        while (i < m && i < n) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            i++;
        }
        if (i > 0) {
            return str2.substring(0, i);
        }
        return "";
    }
}
