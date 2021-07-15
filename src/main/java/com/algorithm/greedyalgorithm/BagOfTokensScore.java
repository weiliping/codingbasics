package com.algorithm.greedyalgorithm;

import java.util.Arrays;

public class BagOfTokensScore {

    /**
     * #948
     * https://leetcode-cn.com/problems/bag-of-tokens/submissions/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{100}, 50));
        System.out.println(bagOfTokensScore(new int[]{100, 200}, 150));
        System.out.println(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }

    public static int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        if (P < tokens[0]) {
            return 0;
        }
        int ans = 0, l = 0, h = tokens.length - 1, points = 0;
        while (l <= h && (P >= tokens[l] || points > 0)) {
            while (l <= h && P >= tokens[l]) {
                P -= tokens[l];
                l++;
                points++;
            }
            ans = Math.max(ans, points);

            if (l <= h && points > 0) {
                P += tokens[h];
                h--;
                points--;
            }
        }
        return ans;
    }
}
