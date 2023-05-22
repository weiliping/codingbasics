package com.algorithm.contest.weeklycontest216;

public class ArrayStringsAreEqual {
    public static void main(String[] args) {
        ArrayStringsAreEqual a = new ArrayStringsAreEqual();
        String[] word1 = new String[] { "ab", "c" };
        String[] word2 = new String[] { "a", "bc" };
        System.out.println(a.arrayStringsAreEqual(word1, word2));

        String[] word11 = new String[] { "a", "cb" };
        String[] word21 = new String[] { "ab", "c" };
        System.out.println(a.arrayStringsAreEqual(word11, word21));

        String[] word12 = new String[] { "abc", "d", "defg" };
        String[] word22 = new String[] { "abcddefg" };
        System.out.println(a.arrayStringsAreEqual(word12, word22));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int k = 0, j = 0, id1 = 0, id2 = 0, n = word1.length, m = word2.length;
        char ch1, ch2;
        while (k < n && j < m) {
            char[] chs = word1[k].toCharArray();
            ch1 = chs[id1++];
            if (id1 >= chs.length) {
                k++;
                id1 = 0;
            }
            char[] chs2 = word2[j].toCharArray();
            ch2 = chs2[id2++];
            if (id2 >= chs2.length) {
                j++;
                id2 = 0;
            }

            if (ch1 != ch2) {
                return false;
            }
        }
        return k == n && j == m;
    }
}
