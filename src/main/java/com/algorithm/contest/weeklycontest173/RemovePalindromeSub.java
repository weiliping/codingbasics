package com.algorithm.contest.weeklycontest173;

public class RemovePalindromeSub {

    public static void main(String[] args) {
        RemovePalindromeSub r = new RemovePalindromeSub();
        System.out.println(r.removePalindromeSub("ababa"));
        System.out.println(r.removePalindromeSub("bbbbbb"));
        System.out.println(r.removePalindromeSub("abb"));
        System.out.println(r.removePalindromeSub("baabb"));
        System.out.println(r.removePalindromeSub(""));
        System.out.println(r.removePalindromeSub("ababb"));
        System.out.println(r.removePalindromeSub("bbaabaaa"));
    }
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] chrs = s.toCharArray();
        return palindrome(chrs, 0, chrs.length - 1) ? 1 : 2;
    }

    boolean palindrome(char[] chrs, int l, int r) {
        while (l < r) {
            if (chrs[l] == chrs[r]) {
                l++;
                r--;
                continue;
            }
            break;
        }
        return l == r || l - 1 == r;
    }
}
