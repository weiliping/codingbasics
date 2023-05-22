package com.algorithm.contest.biweeklycontest69;

public class CapitalizeTitle {
    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("i lOve leetcode"));
    }

    public static String capitalizeTitle(String title) {
        char[] chrs = title.toCharArray();
        int preInd = -1, n = chrs.length;
        for (int j = 0; j <= n; j++) {
            if (j == n || chrs[j] == ' ') {
                if (j > preInd + 3) {
                    int l = preInd + 1;
                    chrs[l] = Character.toUpperCase(chrs[l]);
                }
                preInd = j;
                continue;
            }
            chrs[j] = Character.toLowerCase(chrs[j]);
        }
        return String.valueOf(chrs);
    }
}
