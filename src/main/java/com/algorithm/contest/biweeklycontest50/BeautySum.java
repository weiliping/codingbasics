package com.algorithm.contest.biweeklycontest50;

public class BeautySum {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
        System.out.println(beautySum("aabcbaa"));
    }
    public static int beautySum(String s) {
        int ans = 0, n = s.length();
        char[] chrs = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            int[] cnts = new int[26];
            int chInd = chrs[i] - 'a';
            cnts[chInd]++;
            int max = chInd, min = chInd;
            for (int j = i + 1; j < n; j++) {
                int ind = chrs[j] - 'a';
                cnts[ind]++;
                if (cnts[max] < cnts[ind]) {
                    max = ind;
                }
                if (min == ind) {
                    min = getMin(cnts);
                } else {
                    if (cnts[min] > cnts[ind]) {
                        min = ind;
                    }
                }
                if (cnts[max] > cnts[min]) {
                    ans += cnts[max] - cnts[min];
                }
            }
        }
        return ans;
    }

    static int getMin(int[] cnts) {
        int minInd = -1;
        for (int i = 0; i < 26; i++) {
            if (cnts[i] == 0) {
                continue;
            }
            if (minInd == -1 || cnts[minInd] > cnts[i]) {
                minInd = i;
            }
        }
        return minInd;
    }
}
