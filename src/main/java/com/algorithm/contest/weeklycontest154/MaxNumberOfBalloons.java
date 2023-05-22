package com.algorithm.contest.weeklycontest154;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
    public static int maxNumberOfBalloons(String text) {
        int[] chrs = new int[26];
        Map<Character, Integer> mp = new HashMap<>();

        for (char ch : text.toCharArray()) {
            chrs[ch - 'a']++;
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int min = Math.min(chrs[0], chrs[1]);
        min = Math.min(min, chrs['n' - 'a']);
        min = Math.min(min, chrs['l' - 'a'] / 2);
        min = Math.min(min, chrs['o' - 'a'] / 2);
        return min;
    }
}
