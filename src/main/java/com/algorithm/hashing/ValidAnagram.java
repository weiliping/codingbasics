package com.algorithm.hashing;

import java.util.Arrays;

public class ValidAnagram {
    /**
     * #242
     * https://leetcode-cn.com/problems/valid-anagram
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] sArray = new int[26];
        for (Character c : s.toCharArray()) {
            sArray[c - 'a']++;
        }

        int[] tArray = new int[26];
        for (Character c : t.toCharArray()) {
            tArray[c - 'a']++;
        }
        return Arrays.equals(sArray, tArray);
    }
}
