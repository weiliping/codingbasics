package com.algorithm.contest.weeklycontest268;

public class KMirror {
    public static void main(String[] args) {
        System.out.println(kMirror(2, 5));
        System.out.println(kMirror(3, 7));
        System.out.println(kMirror(7, 17));
    }
    static long sum;
    static int left;
    public static long kMirror(int k, int n) {
        int p = 1;
        left = n;
        sum = 0l;
        while (true) {
            generateNums(p, k);
            if (left == 0) {
                break;
            }
            p++;
        }
        return sum;
    }

    static void generateNums(int n, int k) {
        int[] nums = new int[n];
        int len = (n >> 1);
        if (((n & 1) != 0)) {
            len++;
        }
        dfs(0, len, n, nums, 1, k);
    }

    static void dfs(int s, int len, int n, int[] nums, int start, int k) {
        if (s == len) {
            long sub = toNums(nums);
            String numStr = Long.toString(sub, k);
            if (isPalindrome(numStr)) {
                sum += sub;
                left--;
            }
            return;
        }
        for (int j = start; j < 10; j++) {
            nums[s] = j;
            nums[n - 1 - s] = j;
            if (left > 0) {
                dfs(s + 1, len, n, nums, 0, k);
            }
        }
    }

    static long toNums(int[] nums) {
        long num = 0l;
        int i = 0, n = nums.length;
        while (i < n) {
            num *= 10;
            num += nums[i++];
        }
        return num;
    }

    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
