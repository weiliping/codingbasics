package com.algorithm.contest.weeklycontest226;

public class SplitPalindrome {

    public static void main(String[] args) {
//        System.out.println(canSplitThree("abcbdd"));
//        System.out.println(canSplitThree("bcbddxy"));
//        System.out.println(canSplitThree("juchzcedhfesefhdeczhcujzzvbmoeombv"));
//        System.out.println(canSplitThree("tnzogabxzbxjvvjxbzxbagoznwxongqgmywvinnnivwymgqgnoxw"));
//        System.out.println(canSplitThree("bbab"));
//        System.out.println(canSplitThree("acab"));
        System.out.println(canSplitThree("bdhayssqdwxxzlkbjovopjsdmgulclxzxlclugmdsjpovojbklzxxwdqssyahdbwnmeibsnagevrvngiheniwwmhkqzwtiqfveagfieelwndkhwcjmhitfaxawhcrvmftkpndvmizfhkjwuraqkyyyykqaruwjkhfzimvdnpktfmvrchwaxaftihmjcwhkdnwleeifgaevfqitwzqkhmwwinehignvrvegansbiemnwnzardqaqwveeavlauvycnvkxxsduokzwiekvnoeevkzidskngrfdjiagseysxxvzixsmgkqcbjfkwesnjrccspobprjqqsxiixsqqjrpbopsccrjnsewkfjbcqkgmsxizvxxsyesgaijdfrgnksdizkveeonvkeiwzkoudsxxkvncyvualvaeevwqaqdrazn"));
    }
    public static boolean canSplitThree(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }
        return dfs(dp, n);
    }

    static boolean dfs(boolean[][] dp, int n) {
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j ++) {
                if (dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
