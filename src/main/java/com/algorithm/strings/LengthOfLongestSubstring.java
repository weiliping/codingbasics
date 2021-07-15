package com.algorithm.strings;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    /**
     * #3
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution("abcabcbb"));
        System.out.println(solution("bbbbb"));
        System.out.println(solution("pwwkew"));
    }

    public static int solution(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        Set<Character> uniqueChars = new HashSet<>();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (!uniqueChars.contains(current)) {
                uniqueChars.add(chars[i]);
                max = max > uniqueChars.size() ? max : uniqueChars.size();
            } else {
                while (j < i) {
                    if (chars[j] == current) {
                        j++;
                        break;
                    }
                    uniqueChars.remove(chars[j]);
                    j++;
                }
            }
        }
        return max;
    }
}
