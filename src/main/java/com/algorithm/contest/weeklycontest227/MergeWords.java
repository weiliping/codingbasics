package com.algorithm.contest.weeklycontest227;

public class MergeWords {

    public static void main(String[] args) {
        System.out.println(mergeWords("cabaa", "bcaaa"));
        System.out.println("cbcabaaaaa");
        System.out.println(mergeWords("abcabc", "abdcaba"));
        System.out.println("abdcabcabcaba");
    }

    public static String mergeWords(String word1, String word2) {
        int s1 = 0, s2 = 0, len1 = word1.length(), len2 = word2.length();
        StringBuilder sb = new StringBuilder();
        while (s1 < len1 || s2 < len2) {
            if (s1 == len1) {
                sb.append(word2.substring(s2));
                break;
            }
            if (s2 == len2) {
                sb.append(word1.substring(s1));
                break;
            }
            if (isGreater(s1, s2, len1, len2, word1, word2)) {
                sb.append(word1.charAt(s1++));
            } else {
                sb.append(word2.charAt(s2++));
            }
        }
        return sb.toString();
    }

    private static boolean isGreater(int s1, int s2, int len1, int len2, String word1, String word2) {
        int i = s1, j = s2;
        while (i < len1 || j < len2) {
            if (word1.charAt(i) == word2.charAt(j)) {
                if (i < len1 - 1) {
                    i++;
                }
                if (j < len2 - 1) {
                    j++;
                }
                if (i != len1 - 1 || j != len2 - 1) {
                    continue;
                }
            }
            return word1.charAt(i) > word2.charAt(j);
        }
        return true;
    }
}
