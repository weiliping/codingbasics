package com.algorithm.hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    /**
     * #387
     * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(firstUniqueChar("leetcode"));
        System.out.println(firstUniqueChar("loveleetcode"));
        System.out.println(firstUniqueCharII("leetcode"));
        System.out.println(firstUniqueCharII("loveleetcode"));
    }

    public static int firstUniqueChar(String s) {
        Map<Character, Integer> res = new HashMap<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (res.containsKey(c)) {
                res.put(c, n);
                continue;
            }
            res.put(c, i);
        }

        int cnt = n;
        for (Integer r : res.values()) {
            if (cnt > r) {
                cnt = r;
            }
        }
        return cnt == n ? -1 : cnt;
    }

    public static int firstUniqueCharII(String s) {
        int[] chs = new int[26];
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            chs[c - 'a']++;
        }

        for (int i = 0; i < sChars.length; i++) {
            if (chs[sChars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
