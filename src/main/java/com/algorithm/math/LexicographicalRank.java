package com.algorithm.math;

public class LexicographicalRank {

    /**
     * https://www.interviewbit.com/problems/sorted-permutation-rank/
     *
     * Given a string, find the rank of the string amongst its permutations sorted lexicographically.
     * Assume that no characters are repeated.
     *
     * Input : 'acb'
     * Output : 2
     *
     * The order permutations with letters 'a', 'c', and 'b' : [abc, acb, bac, bca, cab, cba]
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new LexicographicalRank().findRank("DTNGJPURFHYEW"));
    }

    public int findRank(String A) {
        int n = A.length();
        long mul = fact(n);

        int rank = 1;

        int countRight;
        for (int i = 0; i < n; i++) {
            mul /= (n - i);
            countRight = countSmallerInRight(A, i, n);
            rank += mul * countRight;
        }
        return rank;
    }

    static long fact(int n) {
        return (n <= 1) ? n : n * fact(n - 1);
    }

    static int countSmallerInRight(String str, int low, int high) {
        int count = 0;
        for (int i = low + 1; i < high; i++) {
            if (str.charAt(i) < str.charAt(low)) {
                count++;
            }
        }
        return count;
    }

    static int MAX_CHAR = 256;
    static void populateAndIncreaseCount(int[] count, char[] str) {
        int i;

        for (i = 0; i < str.length; ++i) {
            ++count[str[i]];
        }

        for (i = 1; i < MAX_CHAR; ++i) {
            count[i] += count[i - 1];
        }
    }

    static void updatecount(int[] count, char ch) {
        int i;
        for (i = ch; i < MAX_CHAR; ++i) {
            --count[i];
        }
    }

    public int findRankNew(char[] str) {
        int len = str.length;
        long mul = fact(len);
        int rank = 1, i;

        // all elements of count[] are initialized with 0
        int count[] = new int[MAX_CHAR];

        // Populate the count array such that count[i]
        // contains count of characters which are present
        // in str and are smaller than i
        populateAndIncreaseCount(count, str);

        for (i = 0; i < len; ++i) {
            mul /= len - i;

            // count number of chars smaller than str[i]
            // fron str[i+1] to str[len-1]
            rank += count[str[i] - 1] * mul;

            // Reduce count of characters greater than str[i]
            updatecount(count, str[i]);
        }

        return rank;
    }
}
