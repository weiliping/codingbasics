package com.algorithm.contest.weeklycontest150;

import java.util.Arrays;

public class CountCharacters {
    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
        System.out.println(countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }
    public static int countCharacters(String[] words, String chars) {
        int[] targetChars = new int[26], wchrs = new int[26];

        for (char c : chars.toCharArray()) {
            targetChars[c - 'a']++;
        }
        int ans = 0;
        for (String w : words) {
            Arrays.fill(wchrs, 0);
            for (char c : w.toCharArray()) {
                wchrs[c - 'a']++;
            }
            boolean canBeCount = true;
            for (int i = 0; i < 26; i++) {
                if (targetChars[i] < wchrs[i]) {
                    canBeCount = false;
                    break;
                }
            }
            if (canBeCount) {
                ans += w.length();
            }
        }
        return ans;
    }
}
