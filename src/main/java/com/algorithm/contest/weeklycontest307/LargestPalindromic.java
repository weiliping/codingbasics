package com.algorithm.contest.weeklycontest307;

public class LargestPalindromic {

    public static void main(String[] args) {
        System.out.println(largestPalindromic("444947137"));
        System.out.println(largestPalindromic("00009"));
        System.out.println(largestPalindromic("000000"));
        System.out.println(largestPalindromic("00001105"));
        System.out.println(largestPalindromic("00011"));
        System.out.println(largestPalindromic("055905"));
    }

    public static String largestPalindromic(String num) {
        int[] cnts = new int[10];
        char[] nums = num.toCharArray();
        for (char c : nums) {
            cnts[c - '0']++;
        }
        boolean findBig = false, zero = false;
        int n = 0;
        for (int i = 9; i > 0; i--) {
            if (cnts[i] == 0) {
                continue;
            }
            if (!zero && cnts[i] > 1) {
                zero = true;
            }
            if ((cnts[i] & 1) == 0) {
                n += cnts[i];
                continue;
            }
            if (!findBig) {
                findBig = true;
                n += cnts[i];
                continue;
            }
            cnts[i] ^= 1;
            n += cnts[i];
        }
        if (cnts[0] > 0) {
            if (zero) {
                if ((cnts[0] & 1) != 0 && findBig) {
                    cnts[0] = cnts[0] ^ 1;
                }
            } else {
                cnts[0] = !findBig ? 1 : 0;
            }
        }
        n += cnts[0];
        char[] rs = new char[n];
        int l = 0, r = n - 1;
        for (int i = 9; i > -1; i--) {
            if (cnts[i] == 0) {
                continue;
            }
            char ch = (char) (i + '0');
            if ((cnts[i] & 1) == 1) {
                int m = (n >> 1);
                rs[m] = ch;
            }
            int k = cnts[i] >> 1;
            while (k > 0) {
                rs[l++] = ch;
                rs[r--] = ch;
                k--;
            }
        }
        return String.valueOf(rs);
    }
}
