package com.algorithm.contest.weeklycontest245;

public class MakeEqual {

    public static void main(String[] args) {
        MakeEqual m = new MakeEqual();
        System.out.println(m.makeEqual(new String[] {"abc","aabc","bc"}));
        System.out.println(m.makeEqual(new String[] {"ab", "a"}));
        System.out.println(m.makeEqual(new String[] {"caaaaa","aaaaaaaaa","a","bbb","bbbbbbbbb","bbb","cc","cccccccccccc","ccccccc","ccccccc","cc","cccc","c","cccccccc","c"}));
    }
    public boolean makeEqual(String[] words) {
        int[] chrs = new int[26];
        int n = words.length;
        for (String w : words) {
            for (char c : w.toCharArray()) {
                chrs[c - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (chrs[i] != 0 && chrs[i] % n != 0) {
                return false;
            }
        }
        return true;
    }
}
