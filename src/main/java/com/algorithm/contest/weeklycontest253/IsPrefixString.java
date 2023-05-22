package com.algorithm.contest.weeklycontest253;

public class IsPrefixString {
    public static void main(String[] args) {
        IsPrefixString i = new IsPrefixString();
        System.out.println(i.isPrefixString("iloveleetcode", new String[] { "i", "love", "leetcode", "apples" }));
        System.out.println(i.isPrefixString("iloveleetcode", new String[] { "apples", "i", "love", "leetcode" }));
    }

    public boolean isPrefixString(String s, String[] words) {
        int i = 0, n = words.length, m = s.length();
        for (int j = 0; j < n; j++) {
            if (i >= m) {
                return true;
            }
            int len = words[j].length(), endInd = i + len;
            if (endInd > m || !words[j].equals(s.substring(i, endInd))) {
                return false;
            }
            i += len;
        }
        return false;
    }
}
