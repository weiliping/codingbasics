package com.algorithm.greedyalgorithm;

public class LastStoneWeightII {

    public static void main(String[] args) {
        LastStoneWeightII l = new LastStoneWeightII();
//        System.out.println(l.lastStoneWeightIII(new int[] { 2, 7, 4, 1, 8, 1 }));
//        System.out.println(l.lastStoneWeightI(new int[] { 2, 7, 4, 1, 8, 1 }));
//        System.out.println(l.lastStoneWeightII(new int[] { 2, 7, 4, 1, 8, 1 }));
//        System.out.println(l.lastStoneWeightII(new int[] { 31, 26, 33, 21, 40 }));
//        System.out.println(l.lastStoneWeightII(new int[] { 1, 2 }));

        System.out.println(l.validPalindrome("deee"));
    }
    public int lastStoneWeightI(int[] stones) {
        int sum = 0;
        for (int weight : stones) {
            sum += weight;
        }
        int m = sum / 2;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int weight : stones) {
            for (int j = m; j >= weight; --j) {
                dp[j] = dp[j] || dp[j - weight];
            }
        }
        for (int j = m;; --j) {
            if (dp[j]) {
                return sum - 2 * j;
            }
        }
    }
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int m = sum / 2;
        int[] dp = new int[m + 1];
        for (int j = 0; j < n; j++) {
            for (int i = m; i >= stones[j]; i--) {
                dp[i] = Math.max(dp[i], dp[i - stones[j]] + stones[j]);
            }
        }
        return sum - 2 * dp[m];
    }


    public static int lastStoneWeightIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }

        int amount = (sum >> 1);
        if ((sum & 1) != 0) {
            amount++;
        }
        boolean[] dp = new boolean[amount + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = amount; j >= stones[i]; j--) {
                dp[j] |= dp[j - stones[i]];
            }
        }

        for (int j = amount; j >= 0; j--) {
            if (dp[j]) {
                return Math.abs(sum - (j << 1));
            }
        }
        return 0;
    }


    public boolean validPalindrome(String s) {
        int i = 0, n = s.length(), j = n - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            return isValidPalind(s.substring(i, j)) || isValidPalind(s.substring(i + 1, j + 1));
        }
        return true;
    }
    boolean isValidPalind(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
