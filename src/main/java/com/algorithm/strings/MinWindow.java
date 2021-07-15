package com.algorithm.strings;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    /**
     * #76
     * https://leetcode-cn.com/problems/minimum-window-substring/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindowII("ADOBECODEBANC", "ABC"));
    }

    public static String minWindowII(String s, String t) {
        int[] letterCnt = new int[128];
        int left = 0, cnt = 0, minLeft = -1, minLen = Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            ++letterCnt[c];
        }
        for (int i = 0; i < s.length(); i++) {
            if (--letterCnt[s.charAt(i)] >= 0) {
                ++cnt;
            }
            while (cnt == t.length()) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    minLeft = left;
                }

                if (++letterCnt[s.charAt(left)] > 0) {
                    --cnt;
                }
                ++left;
            }
        }
        return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        if (s.length() < t.length()) {
            return "";
        }

        int sl = s.length(), tl = t.length();
        Map<Character, Integer> letterCnt = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = letterCnt.containsKey(c) ? letterCnt.get(c) + 1 : 1;
            letterCnt.put(c, count);
        }

        String res = "";
        int cnt = 0, left = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sl; i++) {
            char sChar = s.charAt(i);
            int charCnt = letterCnt.containsKey(sChar) ? letterCnt.get(sChar) : 0;
            letterCnt.put(sChar, --charCnt);
            if (letterCnt.get(sChar) >= 0) {
                cnt++;
            }
            while (cnt == tl) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    res = s.substring(left, left + minLen);
                }
                char leftC = s.charAt(left);
                letterCnt.put(leftC, letterCnt.get(leftC) + 1);
                if (letterCnt.get(leftC) > 0) {
                    cnt--;
                }
                left++;
            }
        }
        return res;
    }
}
